package net.nildefonso.employeeservice.service;

import net.nildefonso.employeeservice.dto.DepartmentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// @FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
@FeignClient(name = "DEPARTMENT-SERVICE")
public interface APIClient {
    //get Department By Code RESTAPI
    @GetMapping("api/departments/by-code/{department-code}")
    DepartmentDto getDepartmentByCode(@PathVariable("department-code") String code);
}
