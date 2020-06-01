package com.wgcisotto.design.patterns.validator;

import com.wgcisotto.design.patterns.model.Person;

import java.util.function.Supplier;

public interface ValidatorSupplier extends Supplier<Person> {

    default Person validate() {
        return get();
    }
}
