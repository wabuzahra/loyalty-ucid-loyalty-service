package hbc.com.loyalty.UCID.exceptions;

import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler  extends ResponseEntityExceptionHandler {

	     @Override
	    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	                                                                  HttpHeaders headers,
	                                                                  HttpStatus status, WebRequest request) {

	        Map<String, Object> body = new LinkedHashMap<>();
	        body.put("timestamp", new Date());
	        body.put("status", status.value());

	       
	        //Get all errors
	        List<String> errors = ex.getBindingResult()
	                .getFieldErrors()
	                .stream()
	                .map(x -> x.getDefaultMessage())
	                .collect(Collectors.toList());

	        body.put("errors", errors);

	        return new ResponseEntity<>(body, headers, status);

	    }
	     
	     @Override
	     protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	    	 
	    	  Map<String, Object> body = new LinkedHashMap<>();
		        body.put("timestamp", new Date());
		        body.put("status", status.value());

		        //Get all errors
		        /*
		        List<String> errors = ex.getBindingResult()
		                .getFieldErrors()
		                .stream()
		                .map(x -> x.getDefaultMessage())
		                .collect(Collectors.toList()); */

		        body.put("errors", ex.getMessage());

		         status = HttpStatus.METHOD_NOT_ALLOWED;
		        
		        return new ResponseEntity<>(body, headers, status);

	    	 
	    	 
	     }
	   
	     
	     @Override
	     protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
	       
	    	 //ServletWebRequest servletWebRequest = (ServletWebRequest) request;
	         //log.info("{} to {}", servletWebRequest.getHttpMethod(), servletWebRequest.getRequest().getServletPath());
	         //String error = "Malformed JSON request";
	         Map<String, Object> body = new LinkedHashMap<>();
		        body.put("timestamp", new Date());
		        body.put("status", status.value());

		        //Get all errors
		        /*
		        List<String> errors = ex.getBindingResult()
		                .getFieldErrors()
		                .stream()
		                .map(x -> x.getDefaultMessage())
		                .collect(Collectors.toList()); */

		        body.put("errors", ex.getMessage());

		         status = HttpStatus.BAD_REQUEST;
		        
		        return new ResponseEntity<>(body, headers, status);
	         
	         
	        // return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
	     }
	     
	     
	     @Override
	     protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(
	             HttpMediaTypeNotSupportedException ex,
	             HttpHeaders headers,
	             HttpStatus status,
	             WebRequest request) {
	    	 
	    	   Map<String, Object> body = new LinkedHashMap<>();
		        body.put("timestamp", new Date());
		        body.put("status", status.value());

		        //Get all errors
		        /*
		        List<String> errors = ex.getBindingResult()
		                .getFieldErrors()
		                .stream()
		                .map(x -> x.getDefaultMessage())
		                .collect(Collectors.toList()); */

		        body.put("errors", ex.getMessage());

		         status = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
		        
		        return new ResponseEntity<>(body, headers, status);
	         
	     
	     }
	     
	     
	     /*
	     @ResponseStatus(HttpStatus.BAD_REQUEST)
	     @ExceptionHandler(Exception.class)
	     public void defaultExceptionHandler() {
	         // Nothing to do
	     }  */
	     
	     
	    @ExceptionHandler(ExtIdValueNotFoundException.class)
		    public void springHandleNotFound(HttpServletResponse response) throws IOException {
		        response.sendError(HttpStatus.NOT_FOUND.value());
		    }
	    
	    @ExceptionHandler(EmailNotFoundException.class)
	    public void springHandleEmailNotFound(HttpServletResponse response) throws IOException {
	        response.sendError(HttpStatus.NOT_FOUND.value());
	    }
	    
	    @ExceptionHandler(PhoneNotFoundException.class)
	    public void springHandlePhoneNotFound(HttpServletResponse response) throws IOException {
	        response.sendError(HttpStatus.NOT_FOUND.value());
	    }
	    
	    @ExceptionHandler(LoyaltyIdNotFoundException.class)
	    public void springHandleLoyaltyIdNotFound(HttpServletResponse response) throws IOException {
	        response.sendError(HttpStatus.NOT_FOUND.value());
	    	//response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
	    }
	  
	    @ExceptionHandler(EmailAlreadyExistException.class)
	    public void springHandleEmailAlreadyExistException(HttpServletResponse response) throws IOException {
	        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
	        //response.
	    } 
	    
	    @ExceptionHandler(PhoneAlreadyExistException.class)
	    public void springHandlePhoneAlreadyExistException(HttpServletResponse response) throws IOException {
	        response.sendError(HttpStatus.INTERNAL_SERVER_ERROR.value());
	        
	        
	        
	    }
	  
	  /*
	    @ExceptionHandler({ Exception.class })
	     public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
	  	
	         
	         Map<String, Object> body = new LinkedHashMap<>();
		        //body.put("timestamp", new Date());
		      //  body.put("loyaltyID", "");
		        body.put("responseCode", "09");
		        body.put("responseMessage", "failure");
		        body.put("Http_Status", HttpStatus.INTERNAL_SERVER_ERROR);
		        body.put("message", ex.getMessage() );
		       
		        
		        HttpStatus  status = HttpStatus.INTERNAL_SERVER_ERROR;
		        
		     
	         return new ResponseEntity<>(body, status);
	     }  */
	  	

		  
		  

	}


