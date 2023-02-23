package com.solid.etl.transformer;

import java.util.List;

public interface DataTransformer {

    public String transform(String data);

    public List<String> transform(List<String> strList);

}
