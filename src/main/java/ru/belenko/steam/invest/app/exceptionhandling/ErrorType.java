package ru.belenko.steam.invest.app.exceptionhandling;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorType {

    // Internal causes
    UNEXPECTED_INTERNAL_ERROR("01", "Unexpected error aquired: "),
    JSON_PARSE_ERROR("02", "Could not parse JSON: "),
    ITEM_PRICE_PARSE_ERROR("03", "Could not parse item price: "),

    // External causes
    DATA_BASE_ERROR("10", "Could not access DataBase."),
    EXTERNAL_SERVER_REQUEST_ERROR("11", "External servers are down."),
    STEAM_SERVER_REQUEST_ERROR("12", "Steam servers are down."),
    ;

    private final String code;
    private final String description;
}
