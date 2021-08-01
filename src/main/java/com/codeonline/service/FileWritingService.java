package com.codeonline.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWritingService {

    public static void write(String filePath, String data){
        File f = new File(filePath);
        FileWriter myWriter = null;
        try {
            myWriter = new FileWriter(filePath);
            myWriter.write(data);
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                myWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
