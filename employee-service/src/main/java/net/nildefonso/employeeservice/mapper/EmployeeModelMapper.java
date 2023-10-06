package net.nildefonso.employeeservice.mapper;

import net.nildefonso.employeeservice.dto.EmployeeDto;
import net.nildefonso.employeeservice.entity.Employee;

//Implemented class just for exercise purposes but not used
public class EmployeeModelMapper {

    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartmentCode()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode()
        );
    }
}