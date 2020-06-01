package com.wgcisotto.design.patterns.factory;

import com.wgcisotto.design.patterns.function.Function;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Factory<T> extends Supplier<T> {

    default T newInstance(){
        return this.get();
    }


    default List<T> create5(){
        return IntStream.range(0, 5)
                .mapToObj( index -> newInstance())
                .collect(Collectors.toList());
    }

    static <T> Factory<T> createFactory(Supplier<T> supplier) {
        return () -> supplier.get();
    }

    // singleton
    static <T> Factory<T> createFactorySingleton(Supplier<T> supplier) {
        T singleton = supplier.get();
        return () -> singleton;
    }

    static <P, T> Factory<T> createFactory(Function<P, T> constructor, P p) {
        return () -> constructor.apply(p);
    }


}
