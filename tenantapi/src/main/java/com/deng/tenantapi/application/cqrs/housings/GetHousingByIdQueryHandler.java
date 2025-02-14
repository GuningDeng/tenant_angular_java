package com.deng.tenantapi.application.cqrs.housings;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.deng.tenantapi.application.cqrs.QueryHandler;
import com.deng.tenantapi.application.dto.HousingDetailDto;
import com.deng.tenantapi.domain.Housing;
import com.deng.tenantapi.infrastructure.repository.HousingRepository;

@Service
public class GetHousingByIdQueryHandler implements QueryHandler<GetHousingByIdQuery, HousingDetailDto> {
    private final HousingRepository housingRepository;
    private final ModelMapper mapper;

    public GetHousingByIdQueryHandler(HousingRepository housingRepository) {
        this.housingRepository = housingRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public HousingDetailDto handle(GetHousingByIdQuery query) {
        Housing housing = housingRepository.findById(query.getId()).orElseThrow(() -> new RuntimeException("housing not found"));
        return mapper.map(housing, HousingDetailDto.class);
    }
    
}
