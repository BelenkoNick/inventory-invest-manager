package ru.belenko.steam.invest.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.belenko.steam.invest.app.model.CsInventoryItemEntity;

import java.util.UUID;

@Repository
public interface CsInventoryItemRepository extends JpaRepository<CsInventoryItemEntity, UUID>, JpaSpecificationExecutor<CsInventoryItemEntity> {

    @Query(value = "select cii.name from CsInventoryItemEntity cii where cii.id = :id")
    String getNameById(UUID id);

    boolean existsByName(String name);

}
