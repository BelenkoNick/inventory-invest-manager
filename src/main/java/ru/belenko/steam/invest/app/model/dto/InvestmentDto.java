package ru.belenko.steam.invest.app.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Builder
public class InvestmentDto {

    private UUID itemId;

    private Integer quantity;

    private BigDecimal boughtPrice;

    private LocalDate boughtDate;
}
