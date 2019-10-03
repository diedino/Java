package com.krasnov;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteFile {

    public static void writeUsingFiles(String data) {
        try {
            Files.write(Paths.get("results/results.txt"), data.getBytes());
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void writeUsingFileWriter(String data) {
        File file = new File("results/results.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true);
            fr.write(data);
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
