package com.deng.tenantapi.presentation.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deng.tenantapi.application.cqrs.tenants.AddTenantCommand;
import com.deng.tenantapi.application.cqrs.tenants.AddTenantCommandHandler;
import com.deng.tenantapi.application.cqrs.tenants.DeleteTenantCommand;
import com.deng.tenantapi.application.cqrs.tenants.DeleteTenantCommandHandler;
import com.deng.tenantapi.application.cqrs.tenants.UpdateTenantCommand;
import com.deng.tenantapi.application.cqrs.tenants.UpdateTenantCommandHandler;
import com.deng.tenantapi.application.dto.TenantDetailDto;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@CrossOrigin
@RestController
@RequestMapping("tenant/v3")
public class TenantV3CommandsController {
    private final AddTenantCommandHandler addTenantCommandHandler;
    private final DeleteTenantCommandHandler deleteTenantCommandHandler;
    private final UpdateTenantCommandHandler updateTenantCommandHandler;    

    public TenantV3CommandsController(AddTenantCommandHandler addTenantCommandHandler,
            DeleteTenantCommandHandler deleteTenantCommandHandler,
            UpdateTenantCommandHandler updateTenantCommandHandler) {
        this.addTenantCommandHandler = addTenantCommandHandler;
        this.deleteTenantCommandHandler = deleteTenantCommandHandler;
        this.updateTenantCommandHandler = updateTenantCommandHandler;
    }

    @PostMapping("/tenants/")
    public void postTenant(@RequestBody TenantDetailDto tenant){
        AddTenantCommand command = new AddTenantCommand();
        command.setTenantDetailDto(tenant);
        System.out.println("command.getHousing().getTenantId() -> : " + command.getTenantDetailDto().getHousing().getTenantId());
        addTenantCommandHandler.handle(command);

        
    }
    
    @PutMapping("/tenants/{id}")
    public void putTenant(@PathVariable Long id, @RequestBody TenantDetailDto updateTenant) {
        if (id != updateTenant.getId()) {
            throw new RuntimeException("tenant does not exist");
        }
        UpdateTenantCommand updateTenantCommand = new UpdateTenantCommand(updateTenant);
        updateTenantCommandHandler.handle(updateTenantCommand);
    }

    @DeleteMapping("/tenants/{id}")
    public void deleteTanant(@PathVariable Long id){
        DeleteTenantCommand deleteTenantCommand = new DeleteTenantCommand(id);

        deleteTenantCommandHandler.handle(deleteTenantCommand);
    }
}
