package com.solid.etl.reader;

import com.solid.etl.antiCurrption.Convertor;
import com.solid.etl.antiCurrption.model.FileDTO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

// Single Responsibility Principle ( SRP )
public class FileReader implements DataReader<FileDTO>{

    private final String filePath ;
    private BufferedReader reader;

    private Convertor<String,FileDTO> convertor;

    public FileReader(Convertor convertor, String filePath) {
        this.filePath = filePath;
        this.convertor = convertor;
        init();
    }

    public void init(){
        File f = new File(filePath);
        try {
            reader = new BufferedReader(new java.io.FileReader(f));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public FileDTO readData() {
        String line ;
        FileDTO dto ;
        try {
            line = reader.readLine();
            dto = convertor.convert(line);
            if (Objects.isNull(line)) {
                reader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return dto;
    }

    @Override
    public void close() {

    }

}
