package com.wgcisotto.design.patterns;

import com.wgcisotto.design.patterns.function.Function;
import com.wgcisotto.design.patterns.model.Meteo;

public class PlayWithFuncions {

    public static void main(String[] args) {
        Meteo meteo = new Meteo(20);

        Function<Meteo, Integer> readCelsius = Meteo::getTemperature;
        Function<Integer, Double> celsiusToFahrenheit = t -> t*9d/5d + 32d;

        //Chaining
        Function<Meteo, Double> readFahrenheit = readCelsius.andThen(celsiusToFahrenheit);
        System.out.println("Meteo is F " + readFahrenheit.apply(meteo));

        //Composing
        readFahrenheit = celsiusToFahrenheit.compose(readCelsius);
        System.out.println("Meteo is F " + readFahrenheit.apply(meteo));


    }

}
