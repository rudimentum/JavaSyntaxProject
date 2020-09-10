package com.company;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        System.out.println("Choose method of sort : \n" +
                "Press 1 for alphabet sort \n" +
                "Press 2 for length sort \n" +
                "Press 3 for word sort \n> ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String choice = reader.readLine();
            System.out.println("Please, input the name of the source file: \n> ");
            String source = reader.readLine();
            System.out.println("Please, input the name of the final file: \n> ");
            String result = reader.readLine();
            switch (choice) {
                case "1":
                    alphabetSort(source, result);
                    break;
                case "2":
                    lengthSort(source, result);
                    break;
                case "3":
                    wordSort(source, result);
                    break;
                default:
                    System.out.println("Wrong input!");
                    menu();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> lineReader(File file) throws IOException {

        // find file and read
        File sourceFile = file;
        BufferedReader reader = new BufferedReader(new FileReader(sourceFile));

        // put lines is list
        List<String> strings = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            strings.add(line);
        }

        reader.close();

        return strings;

    }

    private static File repeatLinesCounter(String source) throws IOException {

        // put lines in list
        List<String> strings = lineReader(new File(source));

        // create file and write
        File resultFile = new File("repeat.txt");
        resultFile.createNewFile();
        FileWriter writer = new FileWriter(resultFile);

        for (int i = 0; i < strings.size(); i++) {
            int countOfLineRepeat = 0;
            String currentString = strings.get(i);
            for (int j = 0; j < strings.size(); j++) {
                if (currentString.equals(strings.get(j)))
                    countOfLineRepeat++;
            }
            writer.write(currentString+" " +countOfLineRepeat+"\n");
            writer.flush();
        }

        writer.close();

        return resultFile;
    }

    private static void alphabetSort(String source, String result) throws IOException {

        // count repeats, put lines in list
        File sourceFile = repeatLinesCounter(source);
        List<String> strings = lineReader(sourceFile);

        // create file and write
        File resultFile = new File(result);
        resultFile.createNewFile();
        FileWriter writer = new FileWriter(resultFile);

        Collections.sort(strings);
        for (String s : strings) {
            writer.write(s+"\n");
            writer.flush();
        }
        writer.close();

    }

    private static void lengthSort(String source, String result) throws IOException {

        // count repeats, put lines in list
        File sourceFile = repeatLinesCounter(source);
        List<String> strings = lineReader(sourceFile);

        // create file and write
        File resultFile = new File(result);
        resultFile.createNewFile();
        FileWriter writer = new FileWriter(resultFile);

        int count = strings.size();
        for (int i = 0; i < count; i++) {
            String min = strings.get(0);

            for (int j = 0; j < strings.size(); j++) {
                if (min.length() > strings.get(j).length())
                    min = strings.get(j);
            }
            writer.write(min+"\n");
            writer.flush();

            strings.remove(min);

        }
        writer.close();

    }

    private static void wordSort(String source, String result) throws IOException {

        // count repeats, put lines in list
        File sourceFile = repeatLinesCounter(source);
        List<String> strings = lineReader(sourceFile);

        // create file and write
        File resultFile = new File(result);
        resultFile.createNewFile();
        FileWriter writer = new FileWriter(resultFile);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please input the number of the word for sorting, starts from one \n> ");
        int word = Integer.parseInt(reader.readLine());
        word++;
        reader.close();

        int count = strings.size();
        for (int i = 0; i < count; i++) {
            String min = strings.get(0);
            String[] firstArray = min.split("\\s");

            for (int j = 0; j < strings.size(); j++) {

                String[] secondArray = strings.get(j).split("\\s");
                if (firstArray[word].compareTo(secondArray[word]) > 0) {
                    min = strings.get(j);
                }
            }
            writer.write(min+"\n");
            writer.flush();

            strings.remove(min);

        }
        writer.close();
    }

}

