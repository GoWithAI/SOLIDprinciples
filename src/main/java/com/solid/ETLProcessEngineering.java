package com.solid;

import com.solid.etl.antiCurrption.model.FileDTO;
import com.solid.etl.reader.DataReader;
import com.solid.etl.reader.FileReader;
import com.solid.etl.transformer.DataTransformer;
import com.solid.etl.writer.DataWriter;
import com.solid.etl.writer.FileWriter;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

// Intentionally KEEPING DESIGN FLOWS and Bad Code , or How design Can go wrong

// Class do Composition
public class ETLProcessEngineering {
    // Dependency Inversion
    private DataReader<FileDTO> reader; // PENDING - FileDTO changes Generic

    private DataTransformer<FileDTO> transformer;

    private List<DataTransformer<FileDTO>> transformers;
    private DataWriter writer;

    public ETLProcessEngineering(){

    }

    public ETLProcessEngineering(DataReader reader, DataTransformer transformer, DataWriter writer) {
        this.reader = reader;
        this.transformer = transformer;
        this.writer = writer;
    }

    public ETLProcessEngineering(DataReader reader, List<DataTransformer<FileDTO>> transformers, DataWriter writer) {
        this.reader = reader;
        this.transformers = transformers;
        this.writer = writer;
    }


    public DataReader getReader() {
        return reader;
    }

    public void setReader(DataReader reader) {
        this.reader = reader;
    }

    public DataTransformer getTransformer() {
        return transformer;
    }

    public void setTransformer(DataTransformer transformer) {
        this.transformer = transformer;
    }

    public List<DataTransformer<FileDTO>> getTransformers() {
        return transformers;
    }

    public void setTransformers(List<DataTransformer<FileDTO>> transformers) {
        this.transformers = transformers;
    }

    public DataWriter getWriter() {
        return writer;
    }

    public void setWriter(DataWriter writer) {
        this.writer = writer;
    }


    // File Read -> Transform OCP ??
    public void transformFiles2(Path srcDir, Path destDir) throws IOException {

        Files.createDirectories(destDir);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(srcDir)) {
            for (Path sourcePath : stream) {
                if (!Files.isDirectory(sourcePath)) {
                    // Read
                    reader.readData(); /// Owwffffff  DESIGN FLOW haaahaa
                    // transform
                    transformer.transform(new FileDTO()); /// Owwffffff
                    //write
                    writer.writeData(new FileWriter()); /// Owwffffff
                }
            }
        }

    }

    // Follows OCP
    public void transform() throws IOException { // Closed For Modification
        FileDTO dto = reader.readData();
        FileDTO transformedDto = transformer.transform(dto);// transformer open for Extension
        String line = transformedDto.getLine();
        writer.writeData(transformedDto);
    }

    public void fileTransformer() throws IOException { // Closed For Modification
        FileDTO dto = reader.readData();

       /* Function<DataTransformer, List<String>> transformerFun = f -> f.transform(statements);
        List<List<String>> TransformedList = transformers.stream().map(transformerFun).collect(Collectors.toList());*/

        for(DataTransformer tran : transformers){
           tran.transform(dto);
        }

        //List<String> convertedStatements   =  transformers.transform(statements);// transformer open for Extension
        //writer.writeData(convertedStatements);

    }
/*
    public void fileTransformer() throws IOException { // Closed For Modification
        List<String> statements = reader.readData();

        Function<DataTransformer, List<String>> transformerFun = f -> f.transform(statements);
        List<List<String>> TransformedList = transformers.stream().map(transformerFun).collect(Collectors.toList());

        List<String> transformedData = statements;
        for(DataTransformer tran : transformers){
            transformedData = tran.transform(transformedData);
        }

        //List<String> convertedStatements   =  transformers.transform(statements);// transformer open for Extension
        //writer.writeData(convertedStatements);

    }*/

}
