package com.bahadirmemis.springboot.controller;

import com.bahadirmemis.springboot.dto.YorumDto;
import com.bahadirmemis.springboot.exception.YorumNotFoundException;
import com.bahadirmemis.springboot.service.entityservice.YorumEntityService;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/yorumlar/")
public class YorumController {

    @Autowired
    YorumEntityService yorumEntityService;

    /** FIND ALL COMMENTS BY USER ID STEP - 3.1 **/
    @GetMapping("/kullanicilar/{id}")
    public MappingJacksonValue findAllYorumByKullaniciId (@PathVariable Long id) {

        List<YorumDto> list = yorumEntityService.findAllYorumByKullaniciId(id);
        if(list.isEmpty()) {
            throw new YorumNotFoundException(id + " 'idli kullanıcı henüz yorum yazmamıştır.");
        }

        String filterName = "UrunFilter";
        SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("UrunFilter", getYorumFilter("id","adi"));
        filters.addFilter("KullaniciFilter",getYorumFilter("adi","soyadi"));
        return mappingAndFiltersWrap(list,filters);
    }

    /** FIND ALL COMMENTS BY PRODUCT ID STEP - 3.2 **/
    @GetMapping("/urunler/{id}")
    public MappingJacksonValue findAllYorumByUrunId (@PathVariable Long id) {

        List<YorumDto> list = yorumEntityService.findAllYorumByUrunId(id);
        if(list.isEmpty()) {
            throw new YorumNotFoundException(id + " 'idli ürüne henüz yorum yazılmamıştır.");
        }

        SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("UrunFilter", getYorumFilter("id","adi"));
        filters.addFilter("KullaniciFilter",getYorumFilter("adi","soyadi"));
        return mappingAndFiltersWrap(list,filters);
    }

    /** SAVE NEW COMMENT STEP - 3.3 **/
    @PostMapping()
    public ResponseEntity<Object> saveYorum(@RequestBody YorumDto yorumDto) {

        yorumEntityService.save(yorumDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(yorumDto.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    /** DELETE COMMENT BY ID STEP - 3.4 **/
    @DeleteMapping("")
    public void deleteYorumById (@RequestParam(value = "id") Long id) {

        yorumEntityService.deleteYorumById(id);
    }

    /** FILTER METHODS **/
    private SimpleBeanPropertyFilter getYorumFilter(String... propertyArray) {

        return SimpleBeanPropertyFilter.filterOutAllExcept(propertyArray);
    }

    private MappingJacksonValue mappingAndFiltersWrap (Object object,SimpleFilterProvider simpleFilterProvider) {

        MappingJacksonValue mapping = new MappingJacksonValue(object);
        mapping.setFilters(simpleFilterProvider);
        return mapping;
    }
}
