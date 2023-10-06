package net.nildefonso.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Employee-Department Model Information")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDto {
    @Schema(description = "Employee DTO")
    private EmployeeDto employee;
    @Schema(description = "Department DTO")
    private DepartmentDto department;
}
