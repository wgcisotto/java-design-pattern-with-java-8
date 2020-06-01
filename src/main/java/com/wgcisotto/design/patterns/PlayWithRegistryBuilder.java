package com.wgcisotto.design.patterns;

import com.wgcisotto.design.patterns.factory.Factory;
import com.wgcisotto.design.patterns.model.Rectangle;
import com.wgcisotto.design.patterns.model.Shape;
import com.wgcisotto.design.patterns.model.Square;
import com.wgcisotto.design.patterns.model.Triangle;
import com.wgcisotto.design.patterns.registry.Builder;
import com.wgcisotto.design.patterns.registry.Registry;

import java.util.function.Consumer;

public class PlayWithRegistryBuilder {

    @SuppressWarnings("uncked")
    public static void main(String[] args) {

        // Registration of the factroty with the right label
        Consumer<Builder<Shape>>  consumer1 = builder ->
                builder.registry("rectangle", Rectangle::new);
        Consumer<Builder<Shape>>  consumer2 = builder ->
                builder.registry("triangle", Triangle::new);
        Consumer<Builder<Shape>>  consumer3 = builder ->
                builder.registry("square", Square::new);

        Consumer<Builder<Shape>> consumer = consumer1
                .andThen(consumer2)
                .andThen(consumer3);


        Registry registry = Registry.createRegistry(consumer,
                s -> {throw new IllegalArgumentException("Unknown shape: " + s);});

        Factory<Rectangle> buildRectangleFactory = (
                Factory<Rectangle>) registry.buildShapeFactory("rectangle");
        Rectangle rectangle = buildRectangleFactory.newInstance();
        System.out.println("Rectangle: " + rectangle);

        Factory<Triangle> buildTriangleFactory = (
                Factory<Triangle>) registry.buildShapeFactory("triangle");
        Triangle triangle = buildTriangleFactory.newInstance();
        System.out.println("Triangle: " + triangle);

        Factory<Square> buildSquareFactory = (
                Factory<Square>) registry.buildShapeFactory("square");
        Square square = buildSquareFactory.newInstance();
        System.out.println("Square: " + square);

        Factory<Shape> other = (Factory<Shape>) registry.buildShapeFactory("other");
        other.newInstance();

    }

}
