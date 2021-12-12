package com.bahadirmemis.springboot.dao;


import com.bahadirmemis.springboot.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KullaniciDao extends JpaRepository<Kullanici, Long> {

    Optional<Kullanici> findKullaniciByKullaniciAdi(String kullaniciAdi);
}
