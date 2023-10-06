package net.nildefonso.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Department Model Information")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {
    @Schema(description = "Department Id")
    private Long id;

    @Schema(description = "Department Name")
    @NotEmpty(message = "Department name should not be null or empty")
    private String departmentName;

    @Schema(description = "Department Description")
    @NotEmpty(message = "Department description should not be null or empty")
    private String departmentDescription;

    @Schema(description = "Department Code")
    @NotEmpty(message = "Department code should not be null or empty")
    private String departmentCode;
}

