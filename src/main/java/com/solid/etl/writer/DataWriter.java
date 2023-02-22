package com.solid.etl.writer;

// Interface Segregation Principle (ISP)
public interface DataWriter {

    public void writeData(DataWriter reader);

}
