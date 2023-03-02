package com.solid.etl.transformer;

import java.util.List;

public interface DataTransformer<T>  {
    T transform(T t);
}
