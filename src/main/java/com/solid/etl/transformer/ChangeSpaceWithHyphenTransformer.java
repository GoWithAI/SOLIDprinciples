package com.solid.etl.transformer;

import com.solid.etl.antiCurrption.model.FileDTO;

import java.util.List;

public class ChangeSpaceWithHyphenTransformer implements  DataTransformer<FileDTO> {

    @Override
    public FileDTO transform(FileDTO fileDTO) {
        return new FileDTO();
    }
}
