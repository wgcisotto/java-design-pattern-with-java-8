package com.wgcisotto.design.patterns;

import com.wgcisotto.design.patterns.model.Person;
import com.wgcisotto.design.patterns.validator.Validator;

public class PlayWithValidator {

    public static void main(String[] args) {

        Person sarah = new Person("Sarah", 29);
        Person james = new Person(null, 29);
        Person mary = new Person("Mary", -10);
        Person john = new Person("John", 1_000);
        Person linda = new Person(null, 1_000);

        sarah = Validator.validate(p -> p.getName() != null, "The name should be not null ")
            .on(sarah)
            .validate();
        System.out.println("Sarah : " + sarah);

        linda = Validator.validate(p -> p.getName() != null, "The name should be not null ")
                .thenValidate(p -> p.getAge() > 0, "The age should be greather than 0 ")
                .thenValidate(p -> p.getAge() < 150, "The age should be lesser than 150 ")
                .on(linda)
                .validate();
        System.out.println("Linda : " + linda);

        john = Validator.validate(p -> p.getName() != null, "The name should be not null ")
                .thenValidate(p -> p.getAge() > 0, "The age should be greather than 0 ")
                .thenValidate(p -> p.getAge() < 150, "The age should be lesser than 150 ")
                .on(john)
                .validate();
        System.out.println("John : " + john);

        mary = Validator.validate(p -> p.getName() != null, "The name should be not null ")
                .thenValidate(p -> p.getAge() > 0, "The age should be greather than 0 ")
                .thenValidate(p -> p.getAge() < 150, "The age should be lesser than 150 ")
                .on(mary)
                .validate();
        System.out.println("Mary : " + mary);

        james = Validator.validate(p -> p.getName() != null, "The name should be not null ")
                        .on(james)
                        .validate();
        System.out.println("James : " + james);


    }

}
