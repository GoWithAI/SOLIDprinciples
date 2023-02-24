package com.solid.etl.reader;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Single Responsibility Principle ( SRP )
public class FileReader implements DataReader{
    @Override
    public List<String> readData(DataReader reader) {
        //Connect to file
        //read
        // make object
        List<String> list = new ArrayList<>(Arrays.asList("hello how aree u","test code test"));
        ////// IN progress
        return list;
    }

    //DTO
    public List<String> readData(Path srcDir, Path destDir) throws IOException {
        //Connect to file
        Files.createDirectories(destDir);
        try (
                DirectoryStream<Path> stream = Files.newDirectoryStream(srcDir)) {
            for (Path sourcePath : stream) {
                if (!Files.isDirectory(sourcePath)) {

                }
            }
        }
        //read
        // make object
        List<String> list = new ArrayList<>(Arrays.asList("hello how aree u","test code test"));
        ////// IN progress
        return list;
    }


}
