package com.gini.car.internal.mappers;

public interface Mapper <R, T>{

    default T mapFrom(R r) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

//    default U mapToResponse(T entity) {
//        throw new UnsupportedOperationException("Not implemented yet.");
//    }
}
