package com.modules.bcncgroup.core.domain.exception;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(String priceNotFound) {
        super(priceNotFound);
    }
}
