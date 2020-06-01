package com.wgcisotto.design.patterns.visitor;

import com.wgcisotto.design.patterns.function.Function;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public interface Visitor<R> {

    R visit(Object o);

    static <R> Visitor<R> of(Consumer<VisitorBuilder<R>> consumer) {
        Map<Class<?>, Function<Object, R>> registry = new HashMap<>();
        VisitorBuilder<R> visitorBuilder = new VisitorBuilder<R>() {
            @Override
            public <T> void register(Class<T> type, Function<T, R> function) {
                registry.put(type, function.compose(type::cast));
            }
        };
        consumer.accept(visitorBuilder);
        //consumer.accept(registry::put); //not much clear but it's an opnion
        System.out.println("Registry: " + registry.keySet());
        return o -> registry.get(o.getClass()).apply(o);
    }

    static <T, R> X<T, R> forType(Class<T> type) {
        return () -> type;
    }

    interface X<T, R> {

        Class<T> type();

        default Y<R> execute(Function<T, R> function) {
            return visitorBuilder ->  {visitorBuilder.register(type(), function);};
        }

    }

    interface Y<R> extends Consumer<VisitorBuilder<R>>{

        default <T> Z<T, R> forType(Class<T> type){
            return index -> index == 0 ? this : type;
        }

        default Y<R> andThen(Y<R> after){
            return t -> {
                this.accept(t);
                after.accept(t);
            };
        }

    }

    interface Z<T, R> {

        Object get(int index);

        default Class<T> type() {
            return (Class<T>)get(1) ;
        }

        default Y<R> previousConsumer(){
            return (Y<R>) get(0);
        }

        default Y<R> execute(Function<T, R> function) {
            return previousConsumer().andThen(
                    visitorBuilder ->  visitorBuilder.register(type(), function));
        }

    }
}
