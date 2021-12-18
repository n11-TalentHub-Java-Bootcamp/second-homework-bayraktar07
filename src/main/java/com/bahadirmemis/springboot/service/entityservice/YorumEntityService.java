package com.bahadirmemis.springboot.service.entityservice;

import com.bahadirmemis.springboot.converter.YorumConverter;
import com.bahadirmemis.springboot.dao.YorumDao;
import com.bahadirmemis.springboot.dto.YorumDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YorumEntityService {

    @Autowired
    YorumDao yorumDao;

    public List<YorumDto> findAllYorumByKullaniciId(Long id) {
        return YorumConverter.INSTANCE.convertYorumListToYorumDtoList(yorumDao.findAllYorumByKullaniciId(id));
    }

    public List<YorumDto> findAllYorumByUrunId(Long id) {
        return YorumConverter.INSTANCE.convertYorumListToYorumDtoList(yorumDao.findAllYorumByUrunId(id));
    }

    public void deleteYorumById(Long id) {
        yorumDao.deleteById(id);
    }

    public void save(YorumDto yorumDto) {
        yorumDao.save(YorumConverter.INSTANCE.convertYorumDtoToYorum(yorumDto));
    }
}
