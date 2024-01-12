package ru.belenko.steam.invest.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.belenko.steam.invest.app.model.InvestmentEntity;
import ru.belenko.steam.invest.app.model.dto.InvestmentDto;

@Mapper(componentModel = "spring",
        imports = java.util.UUID.class)
public interface InvestmentMapper {

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    InvestmentEntity dtoToEntity(InvestmentDto investmentDto);

    InvestmentDto entityToDto(InvestmentEntity investmentEntity);
}
