package net.nildefonso.departmentservice.mapper;

import net.nildefonso.departmentservice.dto.DepartmentDto;
import net.nildefonso.departmentservice.entity.Department;

//Implemented class just for exercise purposes but not used
public class DepartmentModelMapper {

    public static DepartmentDto mapToDepartmentDto(Department department) {
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
    }

    public static Department mapToDepartment(DepartmentDto departmentDto) {
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode()
        );
    }
}