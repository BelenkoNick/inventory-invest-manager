package ru.belenko.steam.invest.app.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.belenko.steam.invest.app.mapper.InvestmentMapper;
import ru.belenko.steam.invest.app.model.InvestmentEntity;
import ru.belenko.steam.invest.app.model.dto.InvestmentDto;
import ru.belenko.steam.invest.app.model.repository.InvestmentRepository;

@Service
@RequiredArgsConstructor
public class InvestmentService {

    private final InvestmentRepository repository;
    private final InvestmentMapper mapper;

    public void saveInvestment(InvestmentDto investmentDto) {
        InvestmentEntity entity = mapper.dtoToEntity(investmentDto);
        repository.save(entity);
    }
}
