package org.themoviedb.api.utils;

public class HttpResponseException extends Exception {
	private static final long serialVersionUID = 1L;
	private ErrorResult errorResult;
	
	public HttpResponseException(ErrorResult errorResult){
		this.errorResult = errorResult;
	}
	
	public ErrorResult getErrorResult(){
		return this.errorResult;
	}
}
