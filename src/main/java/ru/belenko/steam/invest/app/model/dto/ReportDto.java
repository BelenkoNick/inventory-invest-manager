package ru.belenko.steam.invest.app.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@Builder
public class ReportDto {

    private UUID id;

    private UUID itemId;

    private BigDecimal profit;

    private BigDecimal profitForPiece;

    private BigDecimal profitPercent;
}
