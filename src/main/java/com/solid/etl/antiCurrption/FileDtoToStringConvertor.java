package com.solid.etl.antiCurrption;

import com.solid.etl.antiCurrption.model.FileDTO;

public class FileDtoToStringConvertor implements Convertor<FileDTO, String> {
    @Override
    public String convert(FileDTO dto) {
        return dto.getLine().toString();
    }

}
