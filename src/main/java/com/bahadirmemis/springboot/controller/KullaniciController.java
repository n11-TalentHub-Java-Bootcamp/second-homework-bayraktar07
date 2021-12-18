package com.bahadirmemis.springboot.controller;

import com.bahadirmemis.springboot.dto.KullaniciDto;
import com.bahadirmemis.springboot.exception.KullaniciNotFoundException;
import com.bahadirmemis.springboot.service.entityservice.KullaniciEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/** KullaniciController STEP - 2 **/
@RestController
@RequestMapping("/api/kullanicilar")
public class KullaniciController {

    @Autowired
    private KullaniciEntityService kullaniciEntityService;

    /** GET ALL USERS LIST STEP - 2.1 **/
    @GetMapping("")
    public List<KullaniciDto> findAllKullanici () {
        return kullaniciEntityService.findAll();
    }

    /** GET USER BY USERNAME STEP - 2.2 **/
    @GetMapping("/kullaniciAdi")
    public KullaniciDto findKullaniciByKullaniciAdi (@RequestParam String kullaniciAdi) {
        return kullaniciEntityService.findKullaniciByKullaniciAdi(kullaniciAdi);
    }

    /** GET USER BY PHONE NUMBER STEP - 2.3 **/
    @GetMapping("/KullaniciTelefon")
    public KullaniciDto findKullaniciByTelefon (@RequestParam String telefon) {
        return kullaniciEntityService.findKullaniciByTelefon(telefon);
    }

    /** SAVE NEW USER STEP - 2.4 **/
    @PostMapping()
    public ResponseEntity<Object> saveKullanici (@RequestBody KullaniciDto kullaniciDto) {

        kullaniciEntityService.saveKullanici(kullaniciDto);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(kullaniciDto.getId())
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    /** DELETE USER STEP - 2.5 **/
    @DeleteMapping("")
    public ResponseEntity<Object> deleteKullaniciByKullaniciAdiAndTelefon (@RequestParam(value = "kullaniciAdi") String kullaniciAdi,@RequestParam(value = "telefon") String telefon) {
        List<KullaniciDto> kullaniciList = kullaniciEntityService.deleteKullaniciByKullaniciAdiAndTelefon(kullaniciAdi,telefon);
        if(kullaniciList.isEmpty()) {
            throw new KullaniciNotFoundException(kullaniciAdi + " kullanıcı adı ile " + telefon + " telefonu bilgileri uyuşmamaktadır.");
        }

        return ResponseEntity.ok("Kullanıcı adı: " + kullaniciAdi + ", telefon: " + telefon + " olan " + kullaniciList.size() + " kayıt silindi.");
    }

    /** MODIFY USER INFO STEP - 2.6 **/
    @PutMapping("")
    public ResponseEntity<Object> updateKullanici (@RequestBody KullaniciDto kullaniciDto) {
        kullaniciEntityService.saveKullanici(kullaniciDto);
        return ResponseEntity.ok(kullaniciDto.getId() + " id'li kullanıcı güncellendi.");
    }
}
