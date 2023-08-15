package br.com.carrefour.lancamentoservice.exception;

import br.com.carrefour.lancamentoservice.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LancamentoServiceCustomException.class)
    public ResponseEntity<ErrorResponse> handleLancamentoServiceException(
            LancamentoServiceCustomException lancamentoServiceCustomException) {

        ErrorResponse errorResponse = ErrorResponse.builder()
                .errorCode(lancamentoServiceCustomException.getErrorCode())
                .errorMessage(lancamentoServiceCustomException.getMessage())
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
