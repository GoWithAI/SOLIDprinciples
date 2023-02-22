package com.solid.etl.transformer;

public abstract class AbstractCharactorTransformer implements DataTransformer{

    public boolean isNumeric(String data){
        return false;
    }

    abstract  boolean validateFinalWord(String data);

}
