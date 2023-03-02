package com.solid.etl.writer;

import java.util.List;

// Interface Segregation Principle (ISP)
public interface DataWriter<T> {
    public void init();
    public void writeData(T t);

    void close();
}
