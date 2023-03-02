package com.solid.etl.antiCurrption;

import com.solid.etl.antiCurrption.model.FileDTO;

// If we have DTO or encapsulated object then we need this as converter
public class FileStringToDtoConvertor implements Convertor<String, FileDTO> {

    @Override
    public FileDTO convert(String s) {
        return new FileDTO();
    }
}
