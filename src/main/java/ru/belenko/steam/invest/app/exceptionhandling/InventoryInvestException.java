package ru.belenko.steam.invest.app.exceptionhandling;

import lombok.Getter;

@Getter
public class InventoryInvestException extends RuntimeException {
    private final ErrorType type;

    public InventoryInvestException(ErrorType errorType) {
        this(errorType, errorType.getDescription(), null);
    }

    public InventoryInvestException(ErrorType errorType, String message) {
        this(errorType, errorType.getDescription() + message, null);
    }

    public InventoryInvestException(ErrorType errorType, String message, Throwable cause) {
        super(message, cause);
        this.type = errorType;
    }
}
