package ru.belenko.steam.invest.app.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Rarities {

    GRAY("Gray", "Consumer/standard grade"),
    BLUE("Blue", "Industrial grade"),
    DARK_BLUE("Dark blue", "Mil-spec"),
    PURPLE("Purple", "Restricted"),
    PINK("Pink", "Classified"),
    RED("Red", "Covert"),
    YELLOW("Yellow", "Contraband items")
    ;

    private final String rarityColor;
    private final String rarityDescription;
}
