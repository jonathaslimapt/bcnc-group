package com.modules.bcncgroup.core.exception;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(String priceNotFound) {
        super(priceNotFound);
    }
}
