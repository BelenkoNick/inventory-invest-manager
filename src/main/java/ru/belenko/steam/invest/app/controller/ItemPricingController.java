package ru.belenko.steam.invest.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.belenko.steam.invest.app.service.ItemPricingService;

@RestController
@RequiredArgsConstructor
public class ItemPricingController {

    private final ItemPricingService service;

    @GetMapping(value = "/refresh-pricing")
    public Boolean refreshPricing() {
        return service.refreshPrices();
    }
}
