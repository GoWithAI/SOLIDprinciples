package com.solid.etl.transformer;

public class SpecialCharactorTransformer extends AbstractCharactorTransformer{

    @Override
    boolean validateFinalWord(String data) {
        return false;
    }

    @Override
    public String transform(String data) {
        return null;
    }
}
