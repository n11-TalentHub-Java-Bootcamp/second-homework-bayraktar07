package com.bahadirmemis.springboot.dao;


import com.bahadirmemis.springboot.entity.Yorum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YorumDao extends JpaRepository<Yorum, Long> {


    List<Yorum>  findAllYorumByKullaniciId (@Param(value = "id") Long id);

    List<Yorum> findAllYorumByUrunId(@Param(value = "id") Long id);
}
