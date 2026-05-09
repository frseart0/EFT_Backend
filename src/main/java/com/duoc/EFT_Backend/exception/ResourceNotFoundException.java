package com.duoc.EFT_Backend.exception;

public class ResourceNotFoundException extends RuntimeException {

	public ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(String resourceName, Long id) {
		super("%s no encontrado con id: %d".formatted(resourceName, id));
	}
}
