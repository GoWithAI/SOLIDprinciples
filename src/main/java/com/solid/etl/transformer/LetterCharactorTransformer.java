package com.solid.etl.transformer;

public class LetterCharactorTransformer extends AbstractCharactorTransformer{

    @Override
    boolean validateFinalWord(String data) {
        return false;
    }

    @Override
    public String transform(String data) {
        return "Transformed Data";
    }
}
