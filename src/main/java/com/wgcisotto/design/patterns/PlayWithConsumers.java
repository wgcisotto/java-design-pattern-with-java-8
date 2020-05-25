package com.wgcisotto.design.patterns;

import com.wgcisotto.design.patterns.function.Consumer;

public class PlayWithConsumers {

    public static void main(String[] args) {

        Consumer<String> s1 = s -> System.out.println("S1: " + s);
        Consumer<String> s2 = s -> System.out.println("S2: " + s);

        Consumer<String> s3 = s1.andThen(s2);

        s3.accept("William");
    }

}
