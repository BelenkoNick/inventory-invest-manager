package ru.belenko.steam.invest.app.integration;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import ru.belenko.steam.invest.app.exceptionhandling.ErrorType;
import ru.belenko.steam.invest.app.exceptionhandling.InventoryInvestException;
import ru.belenko.steam.invest.app.integration.dto.SteamPriceOverviewRs;

import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class SteamMarketIntegrationService {

    private final WebClient webClient;
    private final IntegrationUtils integrationUtils;

    public SteamPriceOverviewRs getItemPriceOverview(String id) {
        URI uri = integrationUtils.buildPriceOverviewUrl(URLDecoder.decode(id, StandardCharsets.UTF_8));
        SteamPriceOverviewRs rs;
        try {
            rs = webClient
                    .get()
                    .uri(uri)
                    .retrieve()
                    .bodyToMono(SteamPriceOverviewRs.class)
                    .block();
        } catch (Exception e) {
            throw new InventoryInvestException(ErrorType.STEAM_SERVER_REQUEST_ERROR);
        }
        return rs;
    }
}
