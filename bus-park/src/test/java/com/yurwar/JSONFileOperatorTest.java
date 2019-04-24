package com.yurwar;

import com.yurwar.model.Bus;
import com.yurwar.model.Driver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.io.TempDir;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@DisplayName("JSON file operator test")
class JSONFileOperatorTest {
    private static JSONFileOperator fileOperator;
    private static Bus[] expectedBuses;
    @BeforeAll
    static void initFileOperator() {
        fileOperator = new JSONFileOperator();
        expectedBuses = new Bus[] {
                new Bus(new Driver("Bruce", "Robertson"),
                        "AB 0652 AA",
                        35,
                        "Hyundai",
                        2003,
                        389_465),
                new Bus(new Driver("Boris", "Jones"),
                        "AE 0012 AB",
                        26,
                        "Isuzu",
                        2017,
                        96_455),
                new Bus(new Driver("Carl", "Murphy"),
                        "AA 9112 TK",
                        26,
                        "Mercedes",
                        2007,
                        180_971),
        };
    }

    @Test
    void readTest() {
        Bus[] actualBuses;
        try {
            actualBuses = fileOperator.read("./src/test/resources/test-bus-park.json");
            Assertions.assertArrayEquals(expectedBuses, actualBuses);
        } catch (IOException e) {
            Assertions.fail("Can not read the file", e);
        }
    }
    @Test
    void readNotExistingFileExceptionTest() throws IOException {
        Path notExistingPath = Paths.get("./src/main/test/resources/not-existing-file.json");
        Files.deleteIfExists(notExistingPath);
        Assertions.assertThrows(FileNotFoundException.class, () -> {
            fileOperator.read(notExistingPath.toString());
        });
    }

    @Test
    void writeTest(@TempDir Path tempDir) {
        Path output = tempDir.resolve("tmp-bus-park.json");
        Bus[] actualBuses;
        try {
            fileOperator.write(expectedBuses, output.toString());
            actualBuses = fileOperator.read(output.toString());
            Assertions.assertArrayEquals(expectedBuses, actualBuses);
        } catch (IOException e) {
            Assertions.fail("Can not write to the file", e);
        }
    }
}