package ru.belenko.steam.invest.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.belenko.steam.invest.app.model.dto.CsInventoryItemDto;
import ru.belenko.steam.invest.app.service.CsInventoryItemService;

@RestController
@RequiredArgsConstructor
public class CsInventoryItemController {

    private final CsInventoryItemService service;

    @PostMapping(value = "/cs-inventory-item")
    public void addCsInventoryItem(
            @RequestBody CsInventoryItemDto csInventoryItemDto) {
        service.saveItem(csInventoryItemDto);
    }
}
