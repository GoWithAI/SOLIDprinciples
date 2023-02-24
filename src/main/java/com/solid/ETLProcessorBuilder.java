package com.solid;

import com.solid.etl.reader.DataReader;
import com.solid.etl.transformer.DataTransformer;
import com.solid.etl.writer.DataWriter;

import java.util.List;

public class ETLProcessorBuilder {

    ETLProcessEngineering processEngineering;

    public ETLProcessorBuilder(){
        processEngineering = new ETLProcessEngineering();
    }

    public ETLProcessorBuilder withReader(DataReader reader){
        processEngineering.setReader(reader);
        return this;
    }


    public ETLProcessorBuilder withTransformer(DataTransformer transformer){
        processEngineering.setTransformer(transformer);
        return this;
    }

    public ETLProcessorBuilder withTransformers(List<DataTransformer> transformers){
        processEngineering.setTransformers(transformers);
        return this;
    }

    public ETLProcessorBuilder withWriter(DataWriter writer){
        processEngineering.setWriter(writer);
        return this;
    }

    public ETLProcessEngineering build(){
        return processEngineering;
    }
}
