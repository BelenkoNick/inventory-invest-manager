package ru.belenko.steam.invest.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.belenko.steam.invest.app.model.CsInventoryItemEntity;
import ru.belenko.steam.invest.app.model.dto.CsInventoryItemDto;

@Mapper(componentModel = "spring",
        imports = java.util.UUID.class)
public interface CsInventoryItemMapper {

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    CsInventoryItemEntity dtoToEntity(CsInventoryItemDto csInventoryItemDto);
}
