package com.default_service.gcam.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusinessException extends RuntimeException {
    private int errorCode;

    public BusinessException(int errorCode, String message) {
        super(message); // Call to the superclass constructor
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
