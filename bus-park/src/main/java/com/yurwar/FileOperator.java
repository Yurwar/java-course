package com.yurwar;

import com.yurwar.model.Bus;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileOperator {
    Bus[] read() throws IOException, FileNotFoundException;
    void write(Bus[] objects) throws IOException;
}
