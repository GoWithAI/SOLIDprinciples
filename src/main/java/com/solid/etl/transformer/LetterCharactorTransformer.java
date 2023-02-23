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
        List<String> transformedLines = new ArrayList<>();
        for (String line : strList) {
            StringBuilder sb = new StringBuilder();
            boolean newWord = true;
            for (char c : line.toCharArray()) {
                if (Character.isLetterOrDigit(c)) {
                    if (newWord) {
                        sb.append(Character.toUpperCase(c));
                        newWord = false;
                    } else {
                        sb.append(Character.toLowerCase(c));
                    }
                } else {
                    sb.append(c);
                    newWord = true;
                }
            }
            transformedLines.add(sb.toString());
        }
        return transformedLines;
    }
}
