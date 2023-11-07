package ru.belenko.steam.invest.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.belenko.steam.invest.app.integration.SteamMarketIntegrationService;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {

    private final SteamMarketIntegrationService integrationService;

    @GetMapping(value = "/check-integration")
    public void addCsInventoryItem() {
        System.out.println(integrationService.getItemPriceOverview("Sticker | Natus Vincere | Rio 2022"));
    }
}
