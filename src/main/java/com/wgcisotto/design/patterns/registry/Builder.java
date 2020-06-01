package com.wgcisotto.design.patterns.registry;

import com.wgcisotto.design.patterns.factory.Factory;

public interface Builder<T> {

    void registry(String label, Factory<T> factory);

}
