package com.deng.tenantapi.presentation.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deng.tenantapi.application.cqrs.housings.AddHousingCommand;
import com.deng.tenantapi.application.cqrs.housings.AddHousingCommndHandler;
import com.deng.tenantapi.application.cqrs.housings.DeleteHousingCommand;
import com.deng.tenantapi.application.cqrs.housings.DeleteHousingCommandHandler;
import com.deng.tenantapi.application.cqrs.housings.UpdateHousingCommand;
import com.deng.tenantapi.application.cqrs.housings.UpdateHousingCommandHandler;
import com.deng.tenantapi.domain.Housing;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@CrossOrigin
@RestController
@RequestMapping("housing/v3")
public class HousingV3CommandsController {
    private final AddHousingCommndHandler addHousingCommndHandler;
    private final DeleteHousingCommandHandler deleteHousingCommandHandler;
    private final UpdateHousingCommandHandler updateHousingCommandHandler;
    public HousingV3CommandsController(AddHousingCommndHandler addHousingCommndHandler,
            DeleteHousingCommandHandler deleteHousingCommandHandler,
            UpdateHousingCommandHandler updateHousingCommandHandler) {
        this.addHousingCommndHandler = addHousingCommndHandler;
        this.deleteHousingCommandHandler = deleteHousingCommandHandler;
        this.updateHousingCommandHandler = updateHousingCommandHandler;
    }
    
    @PostMapping("/locations")
    public void postHousing(@RequestBody Housing housing) {
        AddHousingCommand addHousingCommand = new AddHousingCommand();
        addHousingCommand.setHousNumber(housing.getHousNumber());
        addHousingCommand.setIdCard(housing.getIdCard());
        addHousingCommand.setOwner(housing.getOwner());
        addHousingCommndHandler.handle(addHousingCommand);
    }
    
    @PutMapping("/locations/{id}")
    public void putMethodName(@PathVariable Long id, @RequestBody Housing updateHousing) {
        if(id != updateHousing.getId()){
            throw new RuntimeException("Housing does not exist");

        }
        UpdateHousingCommand updateHousingCommand = new UpdateHousingCommand(id, updateHousing);
        updateHousingCommandHandler.handle(updateHousingCommand);        
    }

    @DeleteMapping("/locations/{id}")
    public void deleteHousing(@PathVariable Long id){
        DeleteHousingCommand deleteHousingCommand = new DeleteHousingCommand(id);
        deleteHousingCommandHandler.handle(deleteHousingCommand);
    }

}
