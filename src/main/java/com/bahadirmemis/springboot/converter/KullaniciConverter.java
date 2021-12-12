package com.bahadirmemis.springboot.converter;


import com.bahadirmemis.springboot.dto.KullaniciDto;
import com.bahadirmemis.springboot.entity.Kullanici;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface KullaniciConverter {

    KullaniciConverter INSTANCE = Mappers.getMapper(KullaniciConverter.class);

    @Mapping(target = "id", source = "id")
    List<KullaniciDto> convertAllKullaniciListToKullaniciDtoList (List<Kullanici>  kullanici);
    KullaniciDto convertKullaniciToKullaniciDto(Kullanici kullanici);

}
