package com.solid.etl.reader;

import com.solid.etl.constants.DataSourceEnum;

public class ReaderFactory {

    public static DataReader getReader(DataSourceEnum readerType){
        switch (readerType) {
            case FILE:
                return new FileReader();
            case DB:
                return new DBReader();
            case KAFKA:
                return new KafkaListener();
            case REST:
                return new RestTemplateReader();
            default:
                throw new IllegalArgumentException("Unknown Reader Type : "+ readerType);
        }
    }
}
