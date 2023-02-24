package com.solid;

import com.solid.etl.constants.DataSourceEnum;
import com.solid.etl.reader.DataReader;
import com.solid.etl.reader.FileReader;
import com.solid.etl.reader.ReaderFactory;
import com.solid.etl.transformer.DataTransformer;
import com.solid.etl.transformer.LetterCharactorTransformer;
import com.solid.etl.writer.DataWriter;
import com.solid.etl.writer.FileWriter;
import com.solid.etl.writer.WriterFactory;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

// Intentionally KEEPING DESIGN FLOWS and Bad Code , or How design Can go wrong

// Class do Composition
public class ETLProcessEngineering {
    // Dependency Inversion
    private DataReader reader;

    private DataTransformer transformer;

    private List<DataTransformer> transformers;
    private DataWriter writer;

    public ETLProcessEngineering(){

    }

    public ETLProcessEngineering(DataReader reader, DataTransformer transformer, DataWriter writer) {
        this.reader = reader;
        this.transformer = transformer;
        this.writer = writer;
    }

    public ETLProcessEngineering(DataReader reader, List<DataTransformer> transformers, DataWriter writer) {
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

    public List<DataTransformer> getTransformers() {
        return transformers;
    }

    public void setTransformers(List<DataTransformer> transformers) {
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
                    reader.readData(new FileReader()); /// Owwffffff  DESIGN FLOW haaahaa
                    // transform
                    transformer.transform("    "); /// Owwffffff
                    //write
                    writer.writeData(new FileWriter()); /// Owwffffff
                }
            }
        }

    }

    // Follows OCP
    public void transformFiles(Path srcDir, Path destDir) throws IOException { // Closed For Modification
        List<String> statements = reader.readData();
        List<String> convertedStatements   =  transformer.transform(statements);// transformer open for Extension
        writer.writeData(convertedStatements);

    }

    public void fileTransformer(Path srcDir, Path destDir) throws IOException { // Closed For Modification
        List<String> statements = reader.readData();
/*

        Function<DataTransformer, List<String>> transformerFun = f -> f.transform(statements);
        List<List<String>> TransformedList = transformers.stream().map(transformerFun).collect(Collectors.toList());
*/
        List<String> transformedData = statements;
        for(DataTransformer tran : transformers){
            transformedData = tran.transform(transformedData);
        }

        //List<String> convertedStatements   =  transformers.transform(statements);// transformer open for Extension
        //writer.writeData(convertedStatements);

    }

}
