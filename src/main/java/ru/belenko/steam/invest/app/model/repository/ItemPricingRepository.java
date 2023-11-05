package ru.belenko.steam.invest.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.belenko.steam.invest.app.model.CsInventoryItemEntity;
import ru.belenko.steam.invest.app.model.ItemPricingEntity;

import java.util.UUID;

@Repository
public interface ItemPricingRepository extends JpaRepository<ItemPricingEntity, UUID>, JpaSpecificationExecutor<ItemPricingEntity> {
}
