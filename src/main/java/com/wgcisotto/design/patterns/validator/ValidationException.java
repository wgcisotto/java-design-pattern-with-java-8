package com.wgcisotto.design.patterns.validator;

class ValidationException extends RuntimeException {

    public ValidationException(String errorMessage){
        super(errorMessage);
    }

}
