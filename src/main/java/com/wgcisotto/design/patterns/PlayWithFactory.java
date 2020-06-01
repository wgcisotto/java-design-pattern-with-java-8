package com.wgcisotto.design.patterns;

import com.wgcisotto.design.patterns.factory.Factory;
import com.wgcisotto.design.patterns.model.Circle;

import java.awt.*;
import java.util.List;
import java.util.function.Supplier;

public class PlayWithFactory {

    public static void main(String[] args) {
        // Using supplier
        Supplier<Circle> factory = () -> new Circle();
        System.out.println(factory.get());

        Factory<Circle> otherFactory = Circle::new;
        System.out.println(otherFactory.newInstance());

        Factory<Circle> circleFctory = Factory.createFactory(Circle::new, Color.RED);
        //Factory<Circle> circleFctory2 = Factory.createFactory(Circle::new);
        Circle circle1 = circleFctory.newInstance();
        Circle circle2 = circleFctory.newInstance();
        System.out.println(circle1 == circle2);


        List<Circle> circles = circleFctory.create5();
        System.out.println("List = " + circles);

        Factory<Circle> circleFactorySingleton = Factory.createFactorySingleton(Circle::new);
        Circle circleA = circleFactorySingleton.newInstance();
        Circle circleB = circleFactorySingleton.newInstance();
        System.out.println(circleA == circleB);


    }

}
