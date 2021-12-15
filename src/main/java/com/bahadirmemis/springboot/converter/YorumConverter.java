package com.bahadirmemis.springboot.converter;


import com.bahadirmemis.springboot.dto.YorumDto;
import com.bahadirmemis.springboot.entity.Yorum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface YorumConverter {

    YorumConverter INSTANCE = Mappers.getMapper(YorumConverter.class);

    Yorum convertYorumDtoToYorum (YorumDto yorumDto);

    @Mapping(target = "id", source = "id")
    YorumDto convertYorumToYorumDto (Yorum yorum);
    List<YorumDto> convertYorumListToYorumDtoList (List<Yorum> yorums);
}
