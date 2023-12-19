package ru.belenko.steam.invest.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.belenko.steam.invest.app.exceptionhandling.ErrorType;
import ru.belenko.steam.invest.app.exceptionhandling.InventoryInvestException;
import ru.belenko.steam.invest.app.integration.SteamMarketIntegrationService;
import ru.belenko.steam.invest.app.integration.dto.SteamPriceOverviewRs;
import ru.belenko.steam.invest.app.model.ItemPricingEntity;
import ru.belenko.steam.invest.app.model.repository.CsInventoryItemRepository;
import ru.belenko.steam.invest.app.model.repository.ItemPricingRepository;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemPricingService {

    private final ItemPricingRepository repository;
    private final CsInventoryItemRepository csInventoryItemRepository;

    private final SteamMarketIntegrationService integrationService;

    public String saveItemPricing(UUID itemId) {
        ItemPricingEntity entity = ItemPricingEntity.builder()
                .id(UUID.randomUUID())
                .itemId(itemId)
                .currentPrice(calculatePrice(itemId))
                .pricingDate(OffsetDateTime.now().toLocalDate())
                .build();
        repository.save(entity);
        return String.valueOf(entity.getId());
    }

    public boolean refreshPrices() {
        List<ItemPricingEntity> itemPricingEntityList = repository.findAll().stream().peek(
                item -> {
                    item.setCurrentPrice(calculatePrice(item.getItemId()));
                    item.setPricingDate(OffsetDateTime.now().toLocalDate());
                }
        ).collect(Collectors.toList());
        repository.saveAll(itemPricingEntityList);
        return Boolean.TRUE;
    }

    public BigDecimal calculatePrice(UUID id) {
        String name = csInventoryItemRepository.getNameById(id);
        SteamPriceOverviewRs rs = integrationService.getItemPriceOverview(name);
        return new BigDecimal(getDecimalFromString(rs.getLowestPrice()));
    }

    private String getDecimalFromString(String string) {
        string = string.replace(",", ".");
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(string);
        if(!matcher.find()) {
            throw new InventoryInvestException(ErrorType.ITEM_PRICE_PARSE_ERROR);
        }
        return matcher.group(1);
    }
}
