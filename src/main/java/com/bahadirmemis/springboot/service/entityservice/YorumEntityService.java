package com.bahadirmemis.springboot.service.entityservice;

import com.bahadirmemis.springboot.dao.YorumDao;
import com.bahadirmemis.springboot.entity.Yorum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YorumEntityService {

    @Autowired
    YorumDao yorumDao;


    public List<Yorum> findAllYorumByKullaniciId(Long id) {
        return yorumDao.findAllYorumByKullaniciId(id);
    }

    public List<Yorum> findAllYorumByUrunId(Long id) {
        return yorumDao.findAllYorumByUrunId(id);
    }

    public void deleteYorumById(Long id) {
        yorumDao.deleteById(id);
    }

    public Yorum save(Yorum yorum) {
        return yorumDao.save(yorum);
    }
}
