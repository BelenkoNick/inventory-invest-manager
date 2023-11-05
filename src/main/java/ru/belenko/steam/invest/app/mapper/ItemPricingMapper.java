package ru.belenko.steam.invest.app.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.belenko.steam.invest.app.model.ItemPricingEntity;
import ru.belenko.steam.invest.app.model.dto.ItemPricingDto;

@Mapper(componentModel = "spring",
        imports = java.util.UUID.class)
public interface ItemPricingMapper {

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    ItemPricingEntity dtoToEntity(ItemPricingDto itemPricingDto);
}
