package ru.belenko.steam.invest.app.integration.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SteamPriceOverviewRs {

    private Boolean success;
    @JsonAlias("lowest_price")
    private String lowestPrice;
    private Integer volume;
    @JsonAlias("median_price")
    private String medianPrice;
}
