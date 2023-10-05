package net.nildefonso.departmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceNullException extends RuntimeException{
    public ResourceNullException(String resourceName) {
        super(String.format("%s cannot be null", resourceName));
    }
}
