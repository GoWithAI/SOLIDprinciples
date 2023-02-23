package com.solid.etl.writer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWriter implements DataWriter {
    @Override
    public void writeData(DataWriter reader) {
      //ToDO
    }

    @Override
    public void writeData(List<String> strList) { // Throw exception failure case
        System.out.println("Writting File .......");
    }
}
