package ru.belenko.steam.invest.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.belenko.steam.invest.app.integration.SteamMarketIntegrationService;
import ru.belenko.steam.invest.app.integration.dto.SteamPriceOverviewRs;
import ru.belenko.steam.invest.app.mapper.ItemPricingMapper;
import ru.belenko.steam.invest.app.model.ItemPricingEntity;
import ru.belenko.steam.invest.app.model.dto.CsInventoryItemDto;
import ru.belenko.steam.invest.app.model.dto.ItemPricingDto;
import ru.belenko.steam.invest.app.model.repository.CsInventoryItemRepository;
import ru.belenko.steam.invest.app.model.repository.ItemPricingRepository;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class ItemPricingService {

    private final ItemPricingRepository repository;
    private final CsInventoryItemRepository csInventoryItemRepository;

    private final SteamMarketIntegrationService integrationService;

    public void saveItemPricing(UUID itemId) {
        ItemPricingEntity entity = ItemPricingEntity.builder()
                .id(UUID.randomUUID())
                .itemId(itemId)
                .currentPrice(calculatePrice(itemId))
                .pricingDate(OffsetDateTime.now().toLocalDate())
                .build();
        repository.save(entity);
    }

    public BigDecimal calculatePrice(UUID id) {
        String name = csInventoryItemRepository.getNameById(id);
        SteamPriceOverviewRs rs = integrationService.getItemPriceOverview(name);
        return new BigDecimal(getDecimalFromString(rs.getMedianPrice()));
    }

    private String getDecimalFromString(String string) {
        string = string.replace(",", ".");
        Pattern regex = Pattern.compile("(\\d+(?:\\.\\d+)?)");
        Matcher matcher = regex.matcher(string);
        // TODO add not found case for bad responses
        if(!matcher.find()) {
            throw new RuntimeException();
        }
        return matcher.group(1);
    }
}
