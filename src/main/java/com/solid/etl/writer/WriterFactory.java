package com.solid.etl.writer;

import com.solid.etl.constants.DataSourceEnum;

public class WriterFactory {

    public static DataWriter getReader(DataSourceEnum readerType){
        switch (readerType) {
            case FILE:
                return new FileWriter();
            case DB:
                return new DBWriter();
            case KAFKA:
                return new KafkaPublisher();
            case REST:
                return new RestTemplateWriter();
            default:
                throw new IllegalArgumentException("Unknown Reader Type : "+ readerType);
        }
    }
}
