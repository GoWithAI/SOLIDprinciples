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


// Class do Composition
public class ETLProcessEngineering {
    // Dependency Inversion
    private DataReader reader;
    private DataTransformer transformer;
    private DataWriter writer;

    public ETLProcessEngineering(DataReader reader, DataTransformer transformer, DataWriter writer) {
        this.reader = reader;
        this.transformer = transformer;
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
        List<String> statements = reader.readData(srcDir,destDir);
        List<String> convertedStatements   =  transformer.transform(statements);// transformer open for Extension
        writer.writeData(convertedStatements);

    }

    public static void main(String[] args) throws IOException {
        DataReader fileReader = ReaderFactory.getReader(DataSourceEnum.FILE);
        DataWriter fileWriter = WriterFactory.getReader(DataSourceEnum.FILE);

        DataTransformer dataTransformer = new LetterCharactorTransformer();
        ETLProcessEngineering processEngineering =  new ETLProcessEngineering(fileReader, dataTransformer,fileWriter);

        Path srcDir = Paths.get("D:\\2023 - Practice");
        Path destDir = Paths.get("D:\\2023 - Practice\test");

        processEngineering.transformFiles(srcDir, destDir);

    }


}
