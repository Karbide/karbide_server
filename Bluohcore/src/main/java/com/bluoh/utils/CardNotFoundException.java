package com.bluoh.utils;

public class CardNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CardNotFoundException(String id) {
        super(String.format("No card entry found with id: <%s>", id));
    }
}