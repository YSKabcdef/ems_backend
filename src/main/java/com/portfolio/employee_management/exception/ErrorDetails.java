package com.portfolio.employee_management.exception;

import java.time.LocalDateTime;


public record ErrorDetails(LocalDateTime timestamp, String message,String description ,String id) {

}
