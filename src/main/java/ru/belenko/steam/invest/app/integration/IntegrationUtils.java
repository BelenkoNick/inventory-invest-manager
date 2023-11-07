package ru.belenko.steam.invest.app.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import ru.belenko.steam.invest.app.common.IntegrationConstraints;

import java.net.URI;


@Component
public class IntegrationUtils {

    public URI buildPriceOverviewUrl(String marketHashName) {
        return UriComponentsBuilder.newInstance()
                .scheme(IntegrationConstraints.SCHEME)
                .host(IntegrationConstraints.STEAM_HOST)
                .path(IntegrationConstraints.PRICE_OVERVIEW_URL)
                .queryParam(IntegrationConstraints.CURRENCY, "5")
                .queryParam(IntegrationConstraints.APP_ID, "730")
                .queryParam(IntegrationConstraints.MARKET_HASH_NAME, marketHashName)
                .build()
                .encode()
                .toUri();
    }
}
