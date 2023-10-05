package net.nildefonso.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import net.nildefonso.departmentservice.dto.DepartmentDto;
import net.nildefonso.departmentservice.entity.Department;
import net.nildefonso.departmentservice.exception.ResourceNotFoundException;
import net.nildefonso.departmentservice.exception.ResourceNullException;
import net.nildefonso.departmentservice.mapper.DepartmentMapper;
import net.nildefonso.departmentservice.repository.DepartmentRepository;
import net.nildefonso.departmentservice.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // Convert departmentDto to JPA entity
        Department department = DepartmentMapper.MAPPER.mapToDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);

        // Convert JPA entity to departmentDto
        return DepartmentMapper.MAPPER.mapToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "ID", id.toString()));

        return DepartmentMapper.MAPPER.mapToDepartmentDto(department);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String code) {
        Department department = departmentRepository.findByDepartmentCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Department", "Code", code));;

        return DepartmentMapper.MAPPER.mapToDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();

        return departments.stream().map(DepartmentMapper.MAPPER::mapToDepartmentDto).collect(Collectors.toList());
    }
}
