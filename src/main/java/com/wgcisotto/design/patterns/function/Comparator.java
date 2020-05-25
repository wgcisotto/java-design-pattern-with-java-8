package com.wgcisotto.design.patterns.function;

import java.util.Objects;

@FunctionalInterface
public interface Comparator<T> {

    int compare(T t1, T t2);

    static  <T, U extends Comparable<? super U>> Comparator<T> comparing(Function<T, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (t1, t2) -> {
            U s1 = keyExtractor.apply(t1);
            U s2 = keyExtractor.apply(t2);
            return s1.compareTo(s2);
        };
    }

    default <U extends Comparable<? super U>> Comparator<T> thenComparing(Function<T, U> keyComparator){
        Objects.requireNonNull(keyComparator);
        Comparator<T> other = comparing(keyComparator);
        return this.thenComparing(other);
    }

    default Comparator<T> thenComparing(Comparator<T> other){
        Objects.requireNonNull(other);
        return (T t1, T t2) -> {
            final int compare = this.compare(t1, t2);
            if(compare == 0){
                return other.compare(t1, t2);
            }else{
                return compare;
            }
        };
    }

    default Comparator<T> reversed(){
        return (t1, t2) -> this.compare(t2, t1);
    }
}
