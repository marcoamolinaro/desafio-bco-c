package br.com.carrefour.lancamentoservice.exception;

import lombok.Data;

@Data
public class LancamentoServiceCustomException extends RuntimeException {
    private String errorCode;

    public LancamentoServiceCustomException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
}
