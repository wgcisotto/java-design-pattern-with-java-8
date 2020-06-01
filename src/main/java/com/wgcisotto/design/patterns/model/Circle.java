package com.wgcisotto.design.patterns.model;

import java.awt.*;

public class Circle {

    private Color color;

    public Circle(){
        this(Color.white);
    }

    public Circle(Color color){
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle [color=" + color + "]";
    }
}
