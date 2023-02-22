package com.solid.fileReadWriteDIRTY;


import java.io.*;

public class ETLProcessEngineerGeneralWithoutDesign {
    public static void main(String[] args) {
        String sourceDirPath = args[0];  // Path to source directory
        String destDirPath = args[1];    // Path to destination directory

        File sourceDir = new File(sourceDirPath);
        File[] files = sourceDir.listFiles();

        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    String line;
                    StringBuilder content = new StringBuilder();

                    while ((line = reader.readLine()) != null) {
                        String[] words = line.trim().split("\\s+");

                        for (int i = 0; i < words.length; i++) {
                            String word = words[i];
                            if (word.length() > 0) {
                                char firstLetter = Character.toUpperCase(word.charAt(0));
                                String rest = word.substring(1);
                                words[i] = firstLetter + rest;
                            }
                        }

                        content.append(String.join(" ", words)).append("\n");
                    }

                    String outputFileName = file.getName().replace(".txt", "_initcap.txt");
                    File outputFile = new File(destDirPath, outputFileName);
                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                        writer.write(content.toString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
