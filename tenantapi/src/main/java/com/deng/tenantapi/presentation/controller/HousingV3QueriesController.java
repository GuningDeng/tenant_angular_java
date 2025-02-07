package com.deng.tenantapi.presentation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deng.tenantapi.application.cqrs.housings.GetAllHousingsQueryHandler;
import com.deng.tenantapi.application.cqrs.housings.GetHousingByIdQuery;
import com.deng.tenantapi.application.cqrs.housings.GetHousingByIdQueryHandler;
import com.deng.tenantapi.application.cqrs.housings.GetHousingByOwnerQuery;
import com.deng.tenantapi.application.cqrs.housings.GetHousingByOwnerQueryHandler;
import com.deng.tenantapi.application.dto.HousingDetailDto;
import com.deng.tenantapi.application.dto.HousingDto;


@CrossOrigin
@RestController
@RequestMapping("housing/v3")
public class HousingV3QueriesController {
    private final GetAllHousingsQueryHandler getAllHousingsQueryHandler;
    private final GetHousingByIdQueryHandler getHousingByIdQueryHandler; 
    private final GetHousingByOwnerQueryHandler getHousingByOwnerQueryHandler; 
    
    public HousingV3QueriesController(GetAllHousingsQueryHandler getAllHousingsQueryHandler,
            GetHousingByIdQueryHandler getHousingByIdQueryHandler,
            GetHousingByOwnerQueryHandler getHousingByOwnerQueryHandler) {
        this.getAllHousingsQueryHandler = getAllHousingsQueryHandler;
        this.getHousingByIdQueryHandler = getHousingByIdQueryHandler;
        this.getHousingByOwnerQueryHandler = getHousingByOwnerQueryHandler;
    }

    @GetMapping("/locations")
    public List<HousingDetailDto> getHousings() {
        List<HousingDetailDto> housings = getAllHousingsQueryHandler.handle(null);
        return housings;
    }
    
    @GetMapping("/locations/{id}")
    public HousingDetailDto getHousing(@PathVariable Long id) {
        GetHousingByIdQuery query = new GetHousingByIdQuery(id);
        HousingDetailDto housing = getHousingByIdQueryHandler.handle(query);
        System.out.println(housing.toString());
        return housing;
    }

    /**
     * get List<HousingDto>
     * @param owner
     * @return 
     */
    @GetMapping("/locations/byOwner/{owner}")
    // @ApiOperation(value = "Get housing by owner", notes = "Returns a List<HousingDto>")
    public List<HousingDto> getHousingByOwner(@PathVariable String owner) {
        // List<HousingDto> housingDtos = getHousingsByOwnerQueryService.findHousingsByOwner(owner);
        GetHousingByOwnerQuery query = new GetHousingByOwnerQuery(owner);
        List<HousingDto> housingDtos = getHousingByOwnerQueryHandler.handle(query);
        housingDtos.forEach(h -> System.out.println("housing->: " + h.toString()));
        
        return housingDtos;
    }
}
