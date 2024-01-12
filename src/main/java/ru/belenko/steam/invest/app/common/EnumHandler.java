package ru.belenko.steam.invest.app.common;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EnumHandler {

    public static String checkRarity(String rarity) {
        if(Arrays.stream(Rarities.values()).map(Rarities::getRarityColor).map(String::toLowerCase)
                .collect(Collectors.toSet()).contains(rarity.toLowerCase())) {
            return rarity;
        }
        return  Rarities.GRAY.getRarityColor();
    }

    public static String checkItemType(String type) {
        if(Arrays.stream(ItemTypes.values()).map(ItemTypes::name).map(String::toLowerCase)
                .collect(Collectors.toSet()).contains(type.toLowerCase())) {
            return type;
        }
        return ItemTypes.UNKNOWN.name();
    }
}
