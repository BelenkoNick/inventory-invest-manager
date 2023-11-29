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
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "item_pricings")
public class ItemPricingEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "item_id")
    private UUID itemId;

    @Column(name = "current_price")
    private BigDecimal currentPrice;

    @Column(name = "pricing_date")
    private LocalDate pricingDate;
}
