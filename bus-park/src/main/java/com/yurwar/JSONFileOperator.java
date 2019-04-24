package com.yurwar;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yurwar.model.Bus;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class JSONFileOperator implements FileOperator {
    private Gson parser;
    private String readFilePath;
    private String writeFilePath;

    public String getReadFilePath() {
        return readFilePath;
    }

    public void setReadFilePath(String readFilePath) {
        this.readFilePath = readFilePath;
    }

    public String getWriteFilePath() {
        return writeFilePath;
    }

    public void setWriteFilePath(String writeFilePath) {
        this.writeFilePath = writeFilePath;
    }

    public JSONFileOperator(String filePath) {
        this(filePath, filePath);
    }

    public JSONFileOperator(String readFilePath, String writeFilePath) {
        this();
        this.readFilePath = readFilePath;
        this.writeFilePath = writeFilePath;
    }

    public JSONFileOperator() {
        parser = new GsonBuilder().setPrettyPrinting().create();
    }

    public void write (Bus[] busArr, String filePath) throws IOException {
        String jsonResString = parser.toJson(busArr);
        try(FileWriter fw = new FileWriter(filePath)) {
            fw.write(jsonResString);
        }
    }

    public void write(Bus[] obj) throws IOException {
        write(obj, this.writeFilePath);
    }

    public Bus[] read(String filePath) throws FileNotFoundException, IOException {
        String jsonString;
        Bus[] resArr;
        try(FileInputStream fr = new FileInputStream(filePath)) {
            byte[] byteArr = new byte[fr.available()];
            fr.read(byteArr);
            jsonString = new String(byteArr);
            resArr = parser.fromJson(jsonString, Bus[].class);
        }
        return resArr;
    }

    public Bus[] read() throws FileNotFoundException, IOException {
        return read(this.readFilePath);
    }


}
