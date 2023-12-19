package ru.belenko.steam.invest.app.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.belenko.steam.invest.app.model.CsInventoryItemEntity;
import ru.belenko.steam.invest.app.model.InvestmentEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface InvestmentRepository extends JpaRepository<InvestmentEntity, UUID>, JpaSpecificationExecutor<InvestmentEntity> {

    List<InvestmentEntity> getAllByItemId(@Param("itemId")UUID itemId);
}
