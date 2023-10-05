package net.nildefonso.departmentservice.mapper;

import net.nildefonso.departmentservice.dto.DepartmentDto;
import net.nildefonso.departmentservice.entity.Department;
import org.mapstruct.factory.Mappers;

public interface DepartmentMapper {

    DepartmentMapper MAPPER = Mappers.getMapper(DepartmentMapper.class);

    DepartmentDto mapToDepartmentDto(Department department);

    Department mapToDepartment(DepartmentDto departmentDto);
}
