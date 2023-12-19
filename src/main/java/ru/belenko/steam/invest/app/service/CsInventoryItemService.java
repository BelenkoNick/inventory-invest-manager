package ru.belenko.steam.invest.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.belenko.steam.invest.app.exceptionhandling.ErrorType;
import ru.belenko.steam.invest.app.exceptionhandling.InventoryInvestException;
import ru.belenko.steam.invest.app.mapper.CsInventoryItemMapper;
import ru.belenko.steam.invest.app.model.CsInventoryItemEntity;
import ru.belenko.steam.invest.app.model.dto.CsInventoryItemDto;
import ru.belenko.steam.invest.app.model.repository.CsInventoryItemRepository;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CsInventoryItemService {

    private final CsInventoryItemRepository repository;
    private final CsInventoryItemMapper mapper;

    private final ItemPricingService itemPricingService;

    public CsInventoryItemDto getInventoryItem(UUID itemId) {
        return mapper.entityToDto(repository.getById(itemId));
    }

    @Transactional
    public String saveInventoryItem(CsInventoryItemDto csInventoryItemDto) {
        if(checkDB(csInventoryItemDto.getName())) {
            throw new InventoryInvestException(ErrorType.ITEM_ALREADY_EXIST);
        }
        CsInventoryItemEntity entity = mapper.dtoToEntity(csInventoryItemDto);
        repository.save(entity);

        itemPricingService.saveItemPricing(entity.getId());
        return String.valueOf(entity.getId());
    }

    //TODO add controller for this
    public String updateInventoryItem(CsInventoryItemDto csInventoryItemDto) {
        if(!checkDB(csInventoryItemDto.getName())) {
            throw new InventoryInvestException(ErrorType.ITEM_DONT_EXIST);
        }
        CsInventoryItemEntity entity = mapper.dtoToEntity(csInventoryItemDto);
        repository.save(entity);

        return String.valueOf(entity.getId());
    }

    private boolean checkDB(String name) {
        return repository.existsByName(name);
    }

}
