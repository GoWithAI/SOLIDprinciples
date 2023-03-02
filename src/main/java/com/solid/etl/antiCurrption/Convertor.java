package com.solid.etl.antiCurrption;


public interface Convertor<T, V> {

    V convert(T t);

}
