package model.errors;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public  class AppError {
    private final int numError;
    private final String message;

    private final LocalDateTime date;

    public AppError(int numError, String message) {
        this.numError = numError;
        this.message = message;
        this.date = LocalDateTime.now();

    }
}
