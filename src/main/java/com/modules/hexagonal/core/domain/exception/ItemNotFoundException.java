package com.modules.hexagonal.core.domain.exception;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(String priceNotFound) {
        super(priceNotFound);
    }
}
