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
                "Press 2 for count of symbols sort \n" +
                "Press 3 for word sort ");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String choice = reader.readLine();
            if (choice.equals("1")) {
                alphabetSort();
            } else if (choice.equals("2")) {
                counterSymbols();
            } else if (choice.equals("3")) {

            } else {
                System.out.println("Wrong input!");
                menu();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void alphabetSort() throws IOException {

        // find file and read
        File fileForCount = new File("file.txt");
        BufferedReader reader = new BufferedReader(new FileReader(fileForCount));
        // create file and write
        File counted = new File("counted.txt");
        counted.createNewFile();
        FileWriter writer = new FileWriter(counted);

        List<String> strings = new ArrayList<>();
        // list of reading lines
        String line;
        while ((line = reader.readLine())!=null) {
            // считываем строки в цикле
            strings.add(line);
        }

        Collections.sort(strings);
        for (int i = 0; i < strings.size(); i++) {
            writer.write(strings.get(i)+"\n");
            writer.flush();
        }

    }

    private static void counterSymbols() throws IOException {

        // find file and read
        File fileForCount = new File("file.txt");
        BufferedReader reader = new BufferedReader(new FileReader(fileForCount));
        // create file and write
        File counted = new File("counted.txt");
        counted.createNewFile();
        FileWriter writer = new FileWriter(counted);

        List<String> strings = new ArrayList<>();
        // list of reading lines
        String line;
        while ((line = reader.readLine())!=null) {
            // считываем строки в цикле
            strings.add(line);
        }

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

    }
}
