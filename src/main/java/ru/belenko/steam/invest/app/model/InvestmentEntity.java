package ru.belenko.steam.invest.app.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "investments")
public class InvestmentEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "item_id")
    private UUID itemId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "bought_price")
    private BigDecimal boughtPrice;

    @Column(name = "bought_date")
    private LocalDate boughtDate;
}
