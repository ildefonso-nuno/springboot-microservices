package net.nildefonso.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.nildefonso.employeeservice.dto.EmployeeDto;
import net.nildefonso.employeeservice.entity.Employee;
import net.nildefonso.employeeservice.exception.ResourceNotFoundException;
import net.nildefonso.employeeservice.mapper.EmployeeMapper;
import net.nildefonso.employeeservice.repository.EmployeeRepository;
import net.nildefonso.employeeservice.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        // Convert employeeDto to JPA entity
        Employee employee = EmployeeMapper.MAPPER.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);

        // Convert JPA entity to employeeDto
        return EmployeeMapper.MAPPER.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id.toString()));

        return EmployeeMapper.MAPPER.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map(EmployeeMapper.MAPPER::mapToEmployeeDto).collect(Collectors.toList());
    }
}
