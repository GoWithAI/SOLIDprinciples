package com.solid.etl.antiCurrption;

import com.solid.etl.reader.DataReader;

import java.util.List;

public interface Conveter<T> {

    public T convert(DataReader reader);

}
