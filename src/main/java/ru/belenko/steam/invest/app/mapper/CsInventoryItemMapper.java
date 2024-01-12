package ru.belenko.steam.invest.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;
import ru.belenko.steam.invest.app.model.CsInventoryItemEntity;
import ru.belenko.steam.invest.app.model.dto.CsInventoryItemDto;

@Mapper(componentModel = "spring",
        imports = {java.util.UUID.class, ru.belenko.steam.invest.app.common.EnumHandler.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface CsInventoryItemMapper {

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "rarity", expression = "java(EnumHandler.checkRarity(csInventoryItemDto.getRarity()))")
    @Mapping(target = "type", expression = "java(EnumHandler.checkItemType(csInventoryItemDto.getType()))")
    CsInventoryItemEntity dtoToEntity(CsInventoryItemDto csInventoryItemDto);

    CsInventoryItemEntity updateEntity(CsInventoryItemDto csInventoryItemDto, @MappingTarget CsInventoryItemEntity csInventoryItemEntity);

    CsInventoryItemDto entityToDto(CsInventoryItemEntity csInventoryItemEntity);
}
