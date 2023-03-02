package com.solid.etl.reader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

// Interface Segregation Principle (ISP)

// Challenge Here Each implementation require configuration of its own ??

public interface DataReader<T> {

    public void init();
    public T readData();

    void close();

}
