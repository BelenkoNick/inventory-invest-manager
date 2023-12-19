package ru.belenko.steam.invest.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.belenko.steam.invest.app.model.InvestmentEntity;
import ru.belenko.steam.invest.app.model.ReportEntity;
import ru.belenko.steam.invest.app.model.repository.InvestmentRepository;
import ru.belenko.steam.invest.app.model.repository.ItemPricingRepository;
import ru.belenko.steam.invest.app.model.repository.ReportRepository;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReportService {

    private ReportRepository reportRepository;
    private InvestmentRepository investmentRepository;
    private ItemPricingRepository itemPricingRepository;

    public UUID createReport(UUID itemId) {
        List<InvestmentEntity> investmentEntities = investmentRepository.getAllByItemId(itemId);
        int quantity = (int) investmentEntities.stream()
                .map(InvestmentEntity::getQuantity)
                .count();

        ReportEntity entity = ReportEntity.builder()
                .id(UUID.randomUUID())
                .itemId(itemId)
                .quantity(quantity)
//                TODO add profit calculation
//                .profit()
//                .profitForPiece()
//                .profitPercent()
                .build();
        return reportRepository.save(entity).getId();
    }
}
