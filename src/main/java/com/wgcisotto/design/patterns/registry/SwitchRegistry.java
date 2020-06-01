package com.wgcisotto.design.patterns.registry;

import com.wgcisotto.design.patterns.factory.Factory;
import com.wgcisotto.design.patterns.model.Rectangle;
import com.wgcisotto.design.patterns.model.Shape;
import com.wgcisotto.design.patterns.model.Square;
import com.wgcisotto.design.patterns.model.Triangle;

public class SwitchRegistry {

    public Factory<? extends Shape> buildShapeFactory(String shape){

        switch(shape){
            case "square" : return Square::new;
            case "triangle" : return Triangle::new;
            case "rectangle" : return Rectangle::new;
            default:
                throw new IllegalArgumentException("Unknown shape: " + shape);

        }

    }

}
