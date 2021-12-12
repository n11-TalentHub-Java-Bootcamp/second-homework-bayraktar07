package com.bahadirmemis.springboot.controller;

import com.bahadirmemis.springboot.converter.KullaniciConverter;
import com.bahadirmemis.springboot.dto.KullaniciDto;
import com.bahadirmemis.springboot.entity.Kullanici;
import com.bahadirmemis.springboot.service.entityservice.KullaniciEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kullanicilar")
public class KullaniciController {

    @Autowired
    private KullaniciEntityService kullaniciEntityService;

    @GetMapping("")
    public List<KullaniciDto> findAll () {

        List<Kullanici> list = kullaniciEntityService.findAll();
        return KullaniciConverter.INSTANCE.convertAllKullaniciListToKullaniciDtoList(list);
    }

    @GetMapping("/{kullaniciAdi}")
    public KullaniciDto findKullaniciByKullaniciAdi (@PathVariable String kullaniciAdi) {
        return kullaniciEntityService.findKullaniciByKullaniciAdi(kullaniciAdi);
    }

}
