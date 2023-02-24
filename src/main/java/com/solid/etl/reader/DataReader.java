package com.solid.etl.reader;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

// Interface Segregation Principle (ISP)
public interface DataReader {

    public List<String> readData(DataReader reader);

    //public List<String> readData(Path srcDir, Path destDir) throws IOException;

    public List<String> readData();

}
