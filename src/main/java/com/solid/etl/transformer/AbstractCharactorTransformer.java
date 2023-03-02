package com.solid.etl.transformer;

import com.solid.etl.antiCurrption.model.FileDTO;

// To avoid Lickshov Principle Violation Added Class
public abstract class AbstractCharactorTransformer implements DataTransformer<FileDTO>{

    public boolean isNumeric(String data){
        return false;
    }

    // WordCorrectorTransformer does not support, so here we created new class to avoid LSP violation
    abstract  boolean validateFinalWord(String data);

}
