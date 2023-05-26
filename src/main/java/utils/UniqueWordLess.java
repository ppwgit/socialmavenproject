package utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class UniqueWordLess {
    private static final Logger logger = LogManager.getLogger(UniqueWordLess.class);

    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\ppw\\solvdlab\\socialmaven1\\src\\main\\resources\\textfileRead.txt";
        String outputFilePath = "C:\\Users\\ppw\\solvdlab\\socialmaven1\\src\\main\\resources\\outputText.txt";

        try {
            String text = FileUtils.readFileToString(new File(inputFilePath), "UTF-8");
            int uniqueWordCount = countUniqueWords(text);
            FileUtils.writeStringToFile(new File(outputFilePath), "Number of unique words is: " + uniqueWordCount, "UTF-8");
            logger.info("Write to file successfully!");
        } catch (IOException e) {
            logger.error("An error occurred: " + e.getMessage());
        }
    }

    public static int countUniqueWords(String text) {
        String cleanedText = StringUtils.stripAccents(text.replaceAll("[^a-zA-Z ]", "")).toLowerCase();
        String[] words = cleanedText.split("\\s+");
        return new HashSet<>(Arrays.asList(words)).size();
    }
}