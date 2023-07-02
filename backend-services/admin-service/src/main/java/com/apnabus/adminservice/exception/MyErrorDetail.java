package com.apnabus.adminservice.exception;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class MyErrorDetail {
	private LocalDateTime timestamp;
	private String message;
	private String description;

}
