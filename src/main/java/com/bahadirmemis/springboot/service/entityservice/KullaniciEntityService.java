package com.bahadirmemis.springboot.service.entityservice;

import com.bahadirmemis.springboot.converter.KullaniciConverter;
import com.bahadirmemis.springboot.dao.KullaniciDao;
import com.bahadirmemis.springboot.dto.KullaniciDto;
import com.bahadirmemis.springboot.entity.Kullanici;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KullaniciEntityService {

    @Autowired
    private KullaniciDao kullaniciDao;

    /** Step 2.1 **/
    public List<Kullanici> findAll () {
       return kullaniciDao.findAll();
    }



    /** Step 2.2 **/
    public KullaniciDto findKullaniciByKullaniciAdi (String username) {
        Optional<Kullanici> kullaniciOptional = kullaniciDao.findKullaniciByKullaniciAdi(username);
        Kullanici kullanici = null;
        if (kullaniciOptional.isPresent()){
            kullanici = kullaniciOptional.get();
        }
        return KullaniciConverter.INSTANCE.convertKullaniciToKullaniciDto(kullanici);
    }

    /** Step 2.3 **/
    public KullaniciDto findKullaniciByTelefon (String telefon) {
        Optional<Kullanici> kullaniciOptional = kullaniciDao.findKullaniciByTelefon(telefon);
        Kullanici kullanici = null;
        if(kullaniciOptional.isPresent()) {
            kullanici = kullaniciOptional.get();
        }
        return KullaniciConverter.INSTANCE.convertKullaniciToKullaniciDto(kullanici);
    }

    /** Step 2.4 **/
    public Kullanici save (Kullanici kullanici) {
        return kullaniciDao.save(kullanici);
    }

    /** Step 2.5 **/
    public List<Kullanici> deleteKullaniciByKullaniciAdiAndTelefon (String kullaniciAdi, String telefon) {
        return kullaniciDao.deleteKullaniciByKullaniciAdiAndTelefon(kullaniciAdi,telefon);
    }
}
