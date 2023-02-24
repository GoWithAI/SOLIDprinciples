package com.solid;

import com.solid.etl.constants.DataSourceEnum;
import com.solid.etl.reader.DataReader;
import com.solid.etl.reader.ReaderFactory;
import com.solid.etl.transformer.DataTransformer;
import com.solid.etl.transformer.LetterCharactorTransformer;
import com.solid.etl.writer.DataWriter;
import com.solid.etl.writer.WriterFactory;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ETLProcessingJobTest {

    public static void main(String[] args) throws IOException {
        execute();
        executeWithBuilder();
    }

    private static void executeWithBuilder() throws IOException {
        DataReader fileReader = ReaderFactory.getReader(DataSourceEnum.FILE);
        DataWriter fileWriter = WriterFactory.getReader(DataSourceEnum.FILE);
        DataTransformer dataTransformer = new LetterCharactorTransformer();
        ETLProcessEngineering build = new ETLProcessorBuilder().withReader(fileReader).withTransformer(dataTransformer).withWriter(fileWriter).build();

        Path srcDir = Paths.get("D:\\2023 - Practice");
        Path destDir = Paths.get("D:\\2023 - Practice\test");

        build.transformFiles(srcDir, destDir); // This wrong
    }

    private static void execute() throws IOException {
        DataReader fileReader = ReaderFactory.getReader(DataSourceEnum.FILE);
        DataWriter fileWriter = WriterFactory.getReader(DataSourceEnum.FILE);

        DataTransformer dataTransformer = new LetterCharactorTransformer();
        ETLProcessEngineering processEngineering =  new ETLProcessEngineering(fileReader, dataTransformer,fileWriter);
        // I Love My India
        Path srcDir = Paths.get("D:\\2023 - Practice");
        Path destDir = Paths.get("D:\\2023 - Practice\test");
        processEngineering.transformFiles(srcDir, destDir);
    }

}
