package ru.belenko.steam.invest.app.mapper;

import org.mapstruct.Mapper;
import ru.belenko.steam.invest.app.model.CsInventoryItemEntity;
import ru.belenko.steam.invest.app.model.InvestmentEntity;
import ru.belenko.steam.invest.app.model.dto.CsInventoryItemDto;
import ru.belenko.steam.invest.app.model.dto.InvestmentDto;

@Mapper(componentModel = "spring")
public interface InvestmentMapper {

    InvestmentEntity dtoToEntity(InvestmentDto investmentDto);
}
