package ru.belenko.steam.invest.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "reports")
public class ReportEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "item_id")
    private UUID itemId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "profit")
    private BigDecimal profit;

    @Column(name = "profit_for_piece")
    private BigDecimal profitForPiece;

    @Column(name = "profit_percent")
    private BigDecimal profitPercent;
}
