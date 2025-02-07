package com.deng.tenantapi.application.cqrs.housings;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.deng.tenantapi.application.cqrs.QueryHandler;
import com.deng.tenantapi.application.dto.HousingDetailDto;
import com.deng.tenantapi.domain.Housing;
import com.deng.tenantapi.infrastructure.repository.HousingRepository;

@Service
public class GetAllHousingsQueryHandler implements QueryHandler<GetAllHousingsQuery, List<HousingDetailDto>> {
    private final HousingRepository housingRepository;
    private final ModelMapper mapper;

    public GetAllHousingsQueryHandler(HousingRepository housingRepository) {
        this.housingRepository = housingRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public List<HousingDetailDto> handle(GetAllHousingsQuery t) {
        List<Housing> housings = housingRepository.findAll();
        return housings.stream().map(hous -> mapper.map(hous, HousingDetailDto.class)).toList();
    }

    
    
}
