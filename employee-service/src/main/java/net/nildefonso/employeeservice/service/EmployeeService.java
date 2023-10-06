package net.nildefonso.employeeservice.service;

import net.nildefonso.employeeservice.dto.APIResponseDto;
import net.nildefonso.employeeservice.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);
    APIResponseDto getEmployeeWithDepartmentById(Long id);

    APIResponseDto getEmployeeWebClientById(Long id);

    APIResponseDto getEmployeeApiClientById(Long id);

    List<EmployeeDto> getAllEmployees();
}
