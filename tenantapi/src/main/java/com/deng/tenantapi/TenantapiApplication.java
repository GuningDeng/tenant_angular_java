package com.deng.tenantapi;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.deng.tenantapi.domein.Housing;
import com.deng.tenantapi.domein.Tenant;
import com.deng.tenantapi.repository.HousingRepository;
import com.deng.tenantapi.repository.TenantRepository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;

@SpringBootApplication
public class TenantapiApplication {
	@Resource
	private HousingRepository housingRepository;
	private TenantRepository tenantRepository;

	public static void main(String[] args) {
		SpringApplication.run(TenantapiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			List<Housing> housings = new ArrayList<>();
		Housing housing = new Housing("66", "Jan Jannson", "123456789");
		Housing housing2 = new Housing("88", "Aan van Hovman", "234567891");
		Housing housing3 = new Housing("111", "Aan van Hovman", "234567891");

		housings.add(housing);
		housings.add(housing2);
		housings.add(housing3);

		List<Tenant> tenants = new ArrayList<>();
		Tenant tenant = new Tenant("666666111", "888332", LocalDateTime.of(2022, 2, 1, 12, 00), housing);
		Tenant tenant2 = new Tenant("666666222", "888556", LocalDateTime.of(2020, 12, 1, 18, 00), housing2);

		tenants.add(tenant);
		tenants.add(tenant2);

		housingRepository.saveAll(housings);
		
		// tenantRepository.saveAll(tenants);
		tenants.forEach(t -> System.out.println("tenant->: " + t.getIdCard()));
		
		};
	}
		

	// @PostConstruct
	// public void initRepo() {
	// 	List<Housing> housings = new ArrayList<>();
	// 	Housing housing = new Housing("66", "Jan Jannson", "123456789");
	// 	Housing housing2 = new Housing("88", "Aan van Hovman", "234567891");
	// 	Housing housing3 = new Housing("111", "Aan van Hovman", "234567891");

	// 	housings.add(housing);
	// 	housings.add(housing2);
	// 	housings.add(housing3);

	// 	housingRepository.saveAll(housings);

	// 	List<Tenant> tenants = new ArrayList<>();
	// 	Tenant tenant = new Tenant("666666111", "888332", LocalDateTime.of(2022, 2, 1, 12, 00), housing);
	// 	Tenant tenant2 = new Tenant("666666222", "888556", LocalDateTime.of(2020, 12, 1, 18, 00), housing2);

	// 	tenants.add(tenant);
	// 	tenants.add(tenant2);

	// 	tenants.forEach(t -> System.out.println("tenant->: " + t.toString()));
		


	// }

}
