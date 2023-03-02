package com.solid;

import com.solid.etl.antiCurrption.FileDtoToStringConvertor;
import com.solid.etl.antiCurrption.FileStringToDtoConvertor;
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
import java.nio.file.Path;
import java.nio.file.Paths;

public class ETLProcessingJobTest {

    public static void main(String[] args) throws IOException {
        execute();
        executeWithBuilder();
    }

    private static void executeWithBuilder() throws IOException {
        ETLProcessEngineering build2 = new ETLProcessorBuilder()
                .withReader(new FileReader(new FileStringToDtoConvertor(),"D:\\2023 - Practice"))
                .withTransformer(new LetterCharactorTransformer())
                .withWriter(new FileWriter(new FileDtoToStringConvertor(),"D:\\2023 - Practice\test"))
                .build();
        build2.transform();
    }

    // Booom Again design flow - Bad way to write code
    private static void execute() throws IOException {
        DataReader fileReader = ReaderFactory.getReader(DataSourceEnum.FILE);
        DataWriter fileWriter = WriterFactory.getReader(DataSourceEnum.FILE);

        DataTransformer dataTransformer = new LetterCharactorTransformer();
        ETLProcessEngineering processEngineering =  new ETLProcessEngineering(fileReader, dataTransformer,fileWriter);
        processEngineering.transform();
        Path srcDir = Paths.get("D:\\2023 - Practice");
        Path destDir = Paths.get("D:\\2023 - Practice\test");
        //processEngineering.transformFiles(srcDir, destDir);
    }

}
