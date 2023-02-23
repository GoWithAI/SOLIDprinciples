package com.solid.etl.writer;

import java.util.List;

// Interface Segregation Principle (ISP)
public interface DataWriter {

    public void writeData(DataWriter reader);

    public void writeData(List<String> strList);
}
