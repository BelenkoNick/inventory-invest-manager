package ru.belenko.steam.invest.app.common;

import lombok.experimental.UtilityClass;

@UtilityClass
public class IntegrationConstraints {

    //Scheme & Host
    public static final String SCHEME = "https";
    public static final String STEAM_HOST = "steamcommunity.com";

    //Endpoints
    public static final String MARKET_URL = "/market/listings/730/";
    public static final String PRICE_OVERVIEW_URL = "/market/priceoverview/";

    //Params
    public static final String APP_ID = "appid";
    public static final String CURRENCY = "currency";
    public static final String MARKET_HASH_NAME = "market_hash_name";
}
