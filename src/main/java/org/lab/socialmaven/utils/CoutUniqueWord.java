package org.lab.socialmaven.utils;
import java.io.*;
import java.util.*;

    public class CoutUniqueWord {
        public static void main(String[] args) {
            String inputFilePath = "C:\\Users\\ppw\\solvdlab\\socialmaven1\\src\\main\\resources\\textfileRead.txt";
            String outputFilePath = "C:\\Users\\ppw\\solvdlab\\socialmaven1\\src\\main\\resources\\outputText.txt";


            try {

                BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
                String line;
                Map<String, Integer> wordCountMap = new HashMap<>();

                while ((line = reader.readLine()) != null) {

                    String[] words = line.split("\\s+");

                    for (String word : words) {
                        if (wordCountMap.containsKey(word)) {

                            wordCountMap.put(word, wordCountMap.get(word) + 1);
                        } else {

                            wordCountMap.put(word, 1);
                        }
                    }
                }

                reader.close();


                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

                for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
                    String word = entry.getKey();
                    int count = entry.getValue();
                    writer.write(word + ": " + count);
                    writer.newLine();
                }

                writer.close();

                System.out.println("Word count completed. Results written to " + outputFilePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

