package com.solid.etl.reader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Single Responsibility Principle ( SRP )
public class FileReader implements DataReader{
    @Override
    public List<String> readData(DataReader reader) {
        List<String> list = new ArrayList<>(Arrays.asList("hello how aree u","test code test"));
        ////// IN progress
        return list;
    }
}
