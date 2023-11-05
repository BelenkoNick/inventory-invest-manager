package ru.belenko.steam.invest.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.belenko.steam.invest.app.mapper.ItemPricingMapper;
import ru.belenko.steam.invest.app.model.ItemPricingEntity;
import ru.belenko.steam.invest.app.model.dto.ItemPricingDto;
import ru.belenko.steam.invest.app.model.repository.ItemPricingRepository;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ItemPricingService {

    private ItemPricingRepository repository;
    private ItemPricingMapper mapper;

    public void saveItemPricing(ItemPricingDto itemPricingDto) {
        ItemPricingEntity entity = mapper.dtoToEntity(itemPricingDto);
        entity.setCurrentPrice(calculatePrice(itemPricingDto.getMarketURL()));
        repository.save(entity);
    }

    private BigDecimal calculatePrice(String marketUrl) {


        return null;
    }
}
