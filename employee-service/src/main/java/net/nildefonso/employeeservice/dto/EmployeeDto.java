package net.nildefonso.employeeservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Employee Model Information")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    @Schema(description = "Employee Id")
    private Long id;

    @Schema(description = "Employee First Name")
    @NotEmpty(message = "Employee first name should not be null or empty")
    private String firstName;

    @Schema(description = "Employee Last Name")
    @NotEmpty(message = "Employee last name should not be null or empty")
    private String lastName;

    @Schema(description = "Employee Email")
    @NotEmpty(message = "Employee email should not be null or empty")
    private String email;
}
