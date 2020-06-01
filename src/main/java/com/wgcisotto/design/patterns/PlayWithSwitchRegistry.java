package com.wgcisotto.design.patterns;

import com.wgcisotto.design.patterns.factory.Factory;
import com.wgcisotto.design.patterns.model.Rectangle;
import com.wgcisotto.design.patterns.registry.SwitchRegistry;

public class PlayWithSwitchRegistry {

    public static void main(String[] args) {

        SwitchRegistry registry = new SwitchRegistry();

        Factory<Rectangle> rectangleFactory =
                (Factory<Rectangle>) registry.buildShapeFactory("rectangle");

        System.out.println("Rectangle: " + rectangleFactory.newInstance());

    }

}
