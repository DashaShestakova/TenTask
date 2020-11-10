package com.epam.idea.task.ten.reader;

import com.epam.idea.task.ten.exception.DataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Reader {
    private static final Logger logger = LogManager.getLogger(Reader.class);
    public static final String FILE_PATH = "src/main/resources/input.txt";
    private static final String DELIMITER = "\\n";

    public String readInput() throws DataException {
        try (Scanner scanner = new Scanner(new File(FILE_PATH))) {
            logger.info("Reading text from file " + FILE_PATH);
            return scanner.useDelimiter(DELIMITER).next();
        } catch (IOException e) {
            throw new DataException(e.getMessage());
        }
    }
}
