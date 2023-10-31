package org.lessons.java.list;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        readFile();
        System.out.println("\n");

        Scanner input = new Scanner(System.in);
        List<Present> presents = new ArrayList<>();

        boolean exit = false;

        while (!exit) {
            System.out.println("Insert new person? yes/no");
            String choice = input.nextLine();
            if (choice.equals("yes")) {
                System.out.print("Subject: ");
                String subject = input.nextLine();
                System.out.print("Description: ");
                String description = input.nextLine();
                presents.add(new Present(subject, description));
                System.out.println("Your list contains: " + presents.size() + " present/s");
            } else if (choice.equals("no")) {
                exit = true;
            } else {
                System.out.println("invalid answer");
            }
        }
        System.out.println(presents);
        System.out.println("Write in the file");
        try {
            FileWriter myWriter = new FileWriter("presentlist.txt", true);
            for (Present present : presents) {
                myWriter.write("\n" + "Present" + "\n");
                myWriter.write("Subject: " + present.getSubject() + "\n");
                myWriter.write("Description: " + present.getDescription() + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("invalid file");
        }

        input.close();
    }

    private static void readFile(){
        File file = new File("presentlist.txt");
        if (file.exists()) {
            System.out.println("Presents list: ");
            try (Scanner fileReader = new Scanner(file)) {
                while (fileReader.hasNextLine()) {

                    String line = fileReader.nextLine();
                    System.out.println(line);
                }

            } catch(FileNotFoundException e){
                System.out.println("Unable to read file");
            }
            System.out.println("\n ");
        }
        else {
            System.out.println("There is not a file yet");
        }
    }
}
