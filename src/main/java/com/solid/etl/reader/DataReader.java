package com.solid.etl.reader;

import java.util.List;

// Interface Segregation Principle (ISP)
public interface DataReader {

    public List<String> readData(DataReader reader);

}
