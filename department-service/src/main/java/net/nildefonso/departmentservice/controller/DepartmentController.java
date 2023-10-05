package net.nildefonso.departmentservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import net.nildefonso.departmentservice.dto.DepartmentDto;
import net.nildefonso.departmentservice.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Tag(
        name = "CRUD REST APIs for Department Service",
        description = "CRUD REST APIs - Save Department, Get Department, Get All Departments"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

    //save Department RESTAPI
    @Operation(
            summary = "Save Department REST API",
            description = "Save Department REST API is used to saved the department in the database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@Valid @RequestBody DepartmentDto departmentDto){
        return ResponseEntity.ok(departmentService.saveDepartment(departmentDto));
    }

    //get Department By ID RESTAPI
    @Operation(
            summary = "Get Department by Id REST API",
            description = "Get Department by Id REST API is used to get a single department by id from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{department-id}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("department-id") Long id){
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    //get Department By Code RESTAPI
    @GetMapping("{department-code}")
    @Operation(
            summary = "Get Department by Code REST API",
            description = "Get Department by code by Id REST API is used to get a single department by code from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String Code){
        return ResponseEntity.ok(departmentService.getDepartmentByCode(Code));
    }

    //get All Departments RESTAPI
    @Operation(
            summary = "Get All Departments REST API",
            description = "Get All Departments by Id REST API is used to get all departments from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartments(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }


}
