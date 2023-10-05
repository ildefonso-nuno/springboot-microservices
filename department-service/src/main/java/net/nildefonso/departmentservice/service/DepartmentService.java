package net.nildefonso.departmentservice.service;

import net.nildefonso.departmentservice.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentById(Long id);

    DepartmentDto getDepartmentByCode(String Code);

    List<DepartmentDto> getAllDepartments();
}
