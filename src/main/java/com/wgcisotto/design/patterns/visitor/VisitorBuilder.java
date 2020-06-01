package com.wgcisotto.design.patterns.visitor;

import com.wgcisotto.design.patterns.function.Function;

public interface VisitorBuilder<R> {

    <T> void register(Class<T> type, Function<T, R> function);

}
