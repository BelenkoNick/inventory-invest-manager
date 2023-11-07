package ru.belenko.steam.invest.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.belenko.steam.invest.app.exceptionhandling.ErrorType;
import ru.belenko.steam.invest.app.exceptionhandling.InventoryInvestException;
import ru.belenko.steam.invest.app.mapper.CsInventoryItemMapper;
import ru.belenko.steam.invest.app.model.CsInventoryItemEntity;
import ru.belenko.steam.invest.app.model.dto.CsInventoryItemDto;
import ru.belenko.steam.invest.app.model.repository.CsInventoryItemRepository;

@Service
@RequiredArgsConstructor
public class CsInventoryItemService {

    private final CsInventoryItemRepository repository;
    private final CsInventoryItemMapper mapper;

    private final ItemPricingService itemPricingService;

    public String saveInventoryItem(CsInventoryItemDto csInventoryItemDto) {
        CsInventoryItemEntity entity = mapper.dtoToEntity(csInventoryItemDto);
        repository.save(entity);

        if(itemPricingService.saveItemPricing(entity.getId()) == null) {
            throw new InventoryInvestException(ErrorType.DATA_BASE_ERROR);
        }

        return String.valueOf(entity.getId());
    }

}
