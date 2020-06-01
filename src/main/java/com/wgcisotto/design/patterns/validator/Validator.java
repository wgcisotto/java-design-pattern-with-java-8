package com.wgcisotto.design.patterns.validator;

import com.wgcisotto.design.patterns.function.Predicate;
import com.wgcisotto.design.patterns.model.Person;

public interface Validator {

    ValidatorSupplier on(Person p);

    default Validator thenValidate(Predicate<Person> predicate, String errorMessage){
        return p -> {
            try{
                on(p).validate();
                if(predicate.test(p)){
                    return () -> p;
                }else {
                    return () -> {
                        ValidationException exception = new ValidationException("The object is not valid");
                        exception.addSuppressed(new IllegalAccessException(errorMessage));
                        throw  exception;
                    };
                }

            } catch (ValidationException validationException){
                if(predicate.test(p)){
                    return () -> {throw validationException;};
                }else{
                    validationException.addSuppressed(new IllegalAccessException(errorMessage));
                    return () -> {throw validationException;};
                }
            }
        };
    }

    static Validator validate(Predicate<Person> predicate, String errorMessage){
        return p -> {
            if(predicate.test(p)){
                return () -> p;
            }else{
                return () -> {
                    ValidationException exception = new ValidationException("The object is not valid");
                    exception.addSuppressed(new IllegalAccessException(errorMessage));
                    throw  exception;
                };
            }
        };
    }

}
