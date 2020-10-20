package com.thoughtworks.capacity.gtb.mvc.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResult {

    private String message;
    private HttpStatus code = HttpStatus.BAD_REQUEST;

    public ErrorResult(String message) {
        this.message = message;
    }

    public String getCode() {
        return code.toString();
    }

}
