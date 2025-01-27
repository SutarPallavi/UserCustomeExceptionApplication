package com.springbeanexample.beanexample.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private Date timestamp;
	@JsonProperty
    private int code;
	@JsonProperty
    private String status;
	@JsonProperty
    private String message;

    private String stackTrace;

    private Object data;

    public ErrorResponse() {
        timestamp = new Date();
    }

    public ErrorResponse(HttpStatus httpStatus,String message) {
        this();
    
        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
    }

    public ErrorResponse(HttpStatus httpStatus,String message,String stackTrace) {
        this(
                httpStatus,
                message        
        );

        this.stackTrace = stackTrace;
    }

    public ErrorResponse(HttpStatus httpStatus,String message,String stackTrace,Object data) {
        this(httpStatus,message,stackTrace);
        this.data = data;
    }

	public ErrorResponse(Date timestamp, int code, String status, String message, String stackTrace, Object data) {
		super();
		this.timestamp = timestamp;
		this.code = code;
		this.status = status;
		this.message = message;
		this.stackTrace = stackTrace;
		this.data = data;
	}
}
