package ru.belenko.steam.invest.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.belenko.steam.invest.app.mapper.CsInventoryItemMapper;
import ru.belenko.steam.invest.app.model.CsInventoryItemEntity;
import ru.belenko.steam.invest.app.model.dto.CsInventoryItemDto;
import ru.belenko.steam.invest.app.model.repository.CsInventoryItemRepository;

@Service
@RequiredArgsConstructor
public class CsInventoryItemService {

    private final CsInventoryItemRepository repository;
    private final CsInventoryItemMapper mapper;

    public void saveItem(CsInventoryItemDto csInventoryItemDto) {
        CsInventoryItemEntity entity = mapper.dtoToEntity(csInventoryItemDto);
        repository.save(entity);
    }

}
