package com.wgcisotto.design.patterns;

import com.wgcisotto.design.patterns.model.Body;
import com.wgcisotto.design.patterns.model.Car;
import com.wgcisotto.design.patterns.model.Engine;
import com.wgcisotto.design.patterns.visitor.Visitor;
import com.wgcisotto.design.patterns.visitor.VisitorBuilder;

import java.util.function.Consumer;

public class PlayWithVisitor {

    public static void main(String[] args) {

        Car car = new Car();
        Engine engine = new Engine();
        Body body = new Body();

        // this consumer produces messages
        Consumer<VisitorBuilder<String>> consumer =
                Visitor.<Car, String>forType(Car.class).execute((Car c) -> "Visiting car: " + c)
                        .forType(Engine.class).execute((Engine e) -> "Visiting engine: " + e)
                        .forType(Body.class).execute((Body b) -> "Visiting body: " + b);

        Visitor<String> visitor = Visitor.of(consumer);

        String visitedCar = visitor.visit(car);
        System.out.println("Car: " + visitedCar);

        String visitedEngine = visitor.visit(engine);
        System.out.println("Engine: " + visitedEngine);

        String visitedBody = visitor.visit(body);
        System.out.println("Body: " + visitedBody);
    }

}
