package com.solid.etl.transformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCharactorTransformer extends AbstractCharactorTransformer{

    @Override
    boolean validateFinalWord(String data) {
        return false;
    }

    @Override
    public String transform(String data) {
        return "Transformed Data";
    }

    @Override
    public List<String> transform(List<String> strList) {
        // ToDo Convert from lower letter to upper letter

        return Arrays.asList("I am a great coder who loves to solve real world \n" +
                "problems","Design patterns helps me to write good modular \n" +
                "and extensible code");
    }
}
