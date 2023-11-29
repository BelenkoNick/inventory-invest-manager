package ru.belenko.steam.invest.app.exceptionhandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.belenko.steam.invest.app.exceptionhandling.dto.ErrorInfo;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@RestControllerAdvice
public class InventoryInvestExceptionHandler {

    @ExceptionHandler
    public ErrorInfo handleException(InventoryInvestException exception) {
        return ErrorInfo.builder()
                .code(exception.getType().getCode())
                .description(exception.getMessage())
                .build();
    }
}
