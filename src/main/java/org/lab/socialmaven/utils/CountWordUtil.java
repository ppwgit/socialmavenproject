package org.lab.socialmaven.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CountWordUtil {
    private static final Logger logger = LogManager.getLogger(CountWordUtil.class);

    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\ppw\\solvdlab\\socialmaven1\\src\\main\\resources\\textfileRead.txt";
        String outputFilePath = "C:\\Users\\ppw\\solvdlab\\socialmaven1\\src\\main\\resources\\outputText.txt";

        try {
            String content = FileUtils.readFileToString(new File(inputFilePath), "UTF-8");
            Map<String, Integer> wordCountMap = new HashMap<>();
            for (String word : StringUtils.split(content)) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }

            StringBuilder outputContent = new StringBuilder();
            for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                outputContent.append(" how much time each unique word was included " + entry.getKey()).append(": ").append(entry.getValue()).append(System.lineSeparator());
            }

            FileUtils.writeStringToFile(new File(outputFilePath), outputContent.toString(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Error Read/ Write file " + e);
        }
    }
}