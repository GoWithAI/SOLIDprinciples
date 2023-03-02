package com.solid.etl.transformer;

import com.solid.etl.antiCurrption.model.FileDTO;


public class SpecialCharactorTransformer extends AbstractCharactorTransformer{

    @Override
    boolean validateFinalWord(String data) {
        return false;
    }

    @Override
    public FileDTO transform(FileDTO fileDTO) {
        return null;
    }
}
