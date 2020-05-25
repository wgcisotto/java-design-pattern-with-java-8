package com.wgcisotto.design.patterns;

import com.wgcisotto.design.patterns.function.Predicate;

public class PlayWithPredicates {

    public static void main(String[] args) {

        Predicate<String> s1 = s -> s != null;
//        Predicate<String> s2 = s -> !s.isEmpty();
        Predicate<String> s2 = s -> s.isEmpty();


        Predicate<String> s3 = s1.and(s2.negate());

        System.out.println(s3.test(""));
        System.out.println(s3.test("William"));

        System.out.println();

        Predicate<String> s4 = s1.or(s2.negate());

        System.out.println(s4.test(""));
        System.out.println(s4.test("William"));


    }

}
