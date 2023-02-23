package com.solid.etl.antiCurrption;

import com.solid.etl.reader.DataReader;

import java.util.List;

// If we have DTO or encapsulated object then we need this as converter
public class FileConverter<T> implements Conveter<T>{

    @Override
    public T convert(DataReader reader) {
        // get File Object and convert it into DTO
        return null;
    }
}
