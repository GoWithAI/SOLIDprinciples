package com.solid.etl.transformer;

import java.util.List;

public class SpecialCharactorTransformer extends AbstractCharactorTransformer{

    @Override
    boolean validateFinalWord(String data) {
        return false;
    }

    @Override
    public String transform(String data) {
        return null;
    }

    @Override
    public List<String> transform(List<String> strList) {
        return null;
    }
}
