package ru.belenko.steam.invest.app.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "cs_inventory_items")
public class CsInventoryItemEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "rarity")
    private String rarity;

    @Column(name = "type")
    private String type;

    @Column(name = "tag")
    private String tag;
}
