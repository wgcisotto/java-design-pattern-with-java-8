package com.wgcisotto.design.patterns;

import java.util.function.Supplier;

public class WorkingWithSupplier {

    public static void main(String[] args) {

        Supplier<String> supplier = () -> "Should return this String when get";

        System.out.println(supplier.get());

    }
}
