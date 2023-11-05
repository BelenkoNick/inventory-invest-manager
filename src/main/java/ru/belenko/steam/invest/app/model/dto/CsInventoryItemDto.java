package ru.belenko.steam.invest.app.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CsInventoryItemDto {

    private String name;

    private String rarity;

    private String type;

    private String tag;
}
