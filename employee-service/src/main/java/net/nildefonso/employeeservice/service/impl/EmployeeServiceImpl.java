package net.nildefonso.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import net.nildefonso.employeeservice.dto.APIResponseDto;
import net.nildefonso.employeeservice.dto.DepartmentDto;
import net.nildefonso.employeeservice.dto.EmployeeDto;
import net.nildefonso.employeeservice.entity.Employee;
import net.nildefonso.employeeservice.exception.ResourceNotFoundException;
import net.nildefonso.employeeservice.mapper.EmployeeMapper;
import net.nildefonso.employeeservice.repository.EmployeeRepository;
import net.nildefonso.employeeservice.service.APIClient;
import net.nildefonso.employeeservice.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private RestTemplate restTemplate;

    private WebClient webClient;

    private APIClient apiClient;

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
    public APIResponseDto getEmployeeWithDepartmentById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id.toString()));

        ResponseEntity<DepartmentDto> responseEntity = restTemplate
                .getForEntity("http://localhost:8080/api/departments/by-code/" + employee.getDepartmentCode(),
                        DepartmentDto.class);

        DepartmentDto departmentDto = responseEntity.getBody();

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode());

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

    @Override
    public APIResponseDto getEmployeeWebClientById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id.toString()));

        DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/api/departments/by-code/"+ employee.getDepartmentCode())
                .retrieve()
                .bodyToMono(DepartmentDto.class)
                .block(); // block() because is a synchronous communication

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode());

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

    @Override
    public APIResponseDto getEmployeeApiClientById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "ID", id.toString()));

        DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        EmployeeDto employeeDto = new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode());

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map(EmployeeMapper.MAPPER::mapToEmployeeDto).collect(Collectors.toList());
    }
}
