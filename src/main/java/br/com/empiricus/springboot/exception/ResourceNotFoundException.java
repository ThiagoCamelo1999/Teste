package br.com.empiricus.springboot.exception;

//BY THIAGOSILVA
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resourceName;
	private String fielName;
	private Object fieldValue;
	
	public ResourceNotFoundException(String resourceName, String fielName, Object fieldValue) {
		super(String.format("%s Não Encontrado com %s : '%s'", resourceName, fielName, fieldValue));
		this.resourceName = resourceName;
		this.fielName = fielName;
		this.fieldValue = fieldValue;
	}

	public String getResourceName() {
		return resourceName;
	}

	public String getFielName() {
		return fielName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

	
	
}