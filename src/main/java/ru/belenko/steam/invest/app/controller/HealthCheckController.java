package ru.belenko.steam.invest.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.belenko.steam.invest.app.integration.SteamMarketIntegrationService;
import ru.belenko.steam.invest.app.integration.dto.SteamPriceOverviewRs;

@RestController
@RequiredArgsConstructor
public class HealthCheckController {

    private final SteamMarketIntegrationService integrationService;

    @GetMapping(value = "/health-check")
    public String checkHealth() {
        return "Ok";
    }

    @GetMapping(value = "/check-integration")
    public SteamPriceOverviewRs addCsInventoryItem() {
        return integrationService.getItemPriceOverview("Sticker | Natus Vincere | Rio 2022");
    }
}
