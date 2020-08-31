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

    private static void counterSymbols() throws IOException {

        // find file and read
        File fileForCount = new File("file.txt");
        FileReader fr = new FileReader(fileForCount);
        BufferedReader reader = new BufferedReader(fr);
        // create file and write
        File counted = new File("counted.txt");
        counted.createNewFile();
        FileWriter writer = new FileWriter(counted);

        List<String> strings = new ArrayList<>();
        // list of reading lines
        String line;
        while (true) {
            // считываем строки в цикле
            line = reader.readLine();
            if (line == null)
                break;
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

            // метод flush() выбрасывает всё из буфера в соответствующий поток
            // без него не работает
            writer.flush();

            strings.remove(min);

        }


    }
}
