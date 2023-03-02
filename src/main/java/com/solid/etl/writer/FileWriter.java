package com.solid.etl.writer;

import com.solid.etl.antiCurrption.Convertor;
import com.solid.etl.antiCurrption.model.FileDTO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWriter implements DataWriter<FileDTO> {
    private final String filePath;
    private BufferedWriter writer;

    private Convertor<FileDTO, String> convertor;

    public FileWriter(){
        filePath = "/etc"; // default
    }

    public FileWriter(Convertor<FileDTO, String> convertor, String filePath) {
        this.filePath = filePath;
        this.convertor = convertor;
        init();
    }

    @Override
    public void init() {
        File f = new File(filePath);
        try {
            writer = new BufferedWriter(new java.io.FileWriter(f));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeData(FileDTO dto) {
        try {
            writer.write(convertor.convert(dto));
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
