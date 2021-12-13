package com.bahadirmemis.springboot.dao;


import com.bahadirmemis.springboot.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface KullaniciDao extends JpaRepository<Kullanici, Long> {

    Optional<Kullanici> findKullaniciByKullaniciAdi(String kullaniciAdi);

    @Query("select kullanici from Kullanici kullanici where kullanici.telefon = :telefon")
    Optional<Kullanici> findKullaniciByTelefon(String telefon);


    @Transactional
    List<Kullanici> deleteKullaniciByKullaniciAdiAndTelefon(@Param("kullaniciAdi") String kullaniciAdi, @Param("telefon") String telefon);
}
