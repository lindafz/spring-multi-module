package com.lindazf.smm.company.web;

import com.lindazf.smm.company.data.model.StringResponse;
import com.lindazf.smm.company.data.exception.CompanyException;
import com.lindazf.smm.company.data.exception.CompanyExceptionDetails;
import com.lindazf.smm.company.data.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerController {
//    @Bean
//    public ErrorAttributes errorAttributes() {
//        // Hide exception field in the return object
//        return new DefaultErrorAttributes() {
//
//            @Override
//            public Map<String, Object> getErrorAttributes(WebRequest requestAttributes, boolean includeStackTrace) {
//                @SuppressWarnings("deprecation")
//                Map<String, Object> errorAttributes = super.getErrorAttributes(requestAttributes, includeStackTrace);
//                errorAttributes.remove("exception");
//                return errorAttributes;
//            }
//        };
//    }

    @ExceptionHandler(AccessDeniedException.class)
    public void handleAccessDeniedException(AccessDeniedException ex, HttpServletResponse res) throws IOException {
        log.error("AccessDeniedException Error Message: " + ex.getMessage());
        res.sendError(HttpStatus.FORBIDDEN.value(), "Access Denied Exception: " + ex.getMessage());
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public void handleHttpServerErrorException(HttpServerErrorException ex, HttpServletResponse res)
            throws IOException {
        log.error("HttpServerErrorException Error Message: " + ex.getMessage());
        res.sendError(ex.getStatusCode().value(), "HttpServerErrorException: " + ex.getMessage());
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("Handled IllegalArgumentException", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StringResponse(ex.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(RuntimeException ex) {
        log.error("Handled Runtime Exception", ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StringResponse(ex.getMessage()));
    }

    @ExceptionHandler(CompanyExceptionDetails.class)
    public ResponseEntity<?> handlePortalDetailException(CompanyExceptionDetails pd) {
        String type = pd.getType();
        HttpStatus httpStatus = getHttpStatus(type);
        String result = pd.getMessage();
        log.error("CompanyExceptionDetails Error Type: " + type);
        log.error("CompanyExceptionDetails Error Message: " + result);
        return ResponseEntity.status(httpStatus).body(new StringResponse(result));
    }

    @ExceptionHandler(CompanyException.class)
    public ResponseEntity<?> handlePortalException(CompanyException pe) {
        String result = pe.getMessage();
        HttpStatus httpStatus = getHttpStatus(result);
        log.error("CompanyException Error Type: " + httpStatus);
        log.error("CompanyException Error Message: " + result);
        return ResponseEntity.status(httpStatus).body(new StringResponse(result));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneralException(Exception ex) {
        String result = ex.getMessage();
        log.error("Exception Error Message: " + result);
        HttpStatus httpStatus = getHttpStatus(result);
        return ResponseEntity.status(httpStatus).body(new StringResponse(result));
    }

    private HttpStatus getHttpStatus(String result) {
        if (result.contains(ErrorCode.BAD_REQUEST)) {
            return HttpStatus.BAD_REQUEST;
        }
        if (result.contains(ErrorCode.CONFLICT)) {
            return HttpStatus.CONFLICT;
        }
        if (result.contains(ErrorCode.NOT_FOUND)) {
            return HttpStatus.NOT_FOUND;
        }
        if (result.contains(ErrorCode.UNAUTHORIZED) || result.contains(ErrorCode.FORBIDDEN)) {
            return HttpStatus.FORBIDDEN;
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
