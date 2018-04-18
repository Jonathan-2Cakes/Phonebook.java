/**
 * Created by Erik Reep and Jonathan DeKoekkoek on 4/3/2018.
 */
import java.util.*;
import java.io.*;

public class Phonebook {

    public static Entry[] entryList = new Entry[200]; //global variable
    public static int numEntries = 0; //global variable

    public static void main(String[] args) throws FileNotFoundException {
        Scanner stdin = new Scanner(System.in);
        String command, name, number, notes,n;
        char quitCondition;
        boolean success;

        command = "";
        quitCondition = 'a';
        n = "";


        numEntries = readPhoneBook();

        File f = new File("C:\\Users\\Jonathan\\IdeaProjects\\Phonebook.java\\src\\entries.txt");
        //main is gucci
        System.out.println("Use \"e\" for enter, \"f\" for find, \"l\" for list, \"q\" for quit.");

        while (!(quitCondition == 'q')) {
            System.out.print("Command: ");
            command = stdin.nextLine();

            switch (command.charAt(0)) {
                case 'e':
                    name = command.substring(2);

                    System.out.print("Enter Number: ");
                    number = stdin.nextLine();

                    System.out.print("Enter Notes: ");
                    notes = stdin.nextLine();

                    System.out.println(" ");
                    entryList[numEntries]= new Entry(name, number, notes);
                    numEntries++;
                    break;
                case 'f':
                    System.out.print("Enter Name: ");
                    n = stdin.nextLine();
                    for (int i = 0; i < numEntries; i++){
                        if (n == entryList[i].name);
                        System.out.println("-- " + entryList[i].name);
                        System.out.println("-- " + entryList[i].number);
                        System.out.println("-- " + entryList[i].notes);
                        System.out.println(" ");

                    }
                    break;
                case 'l':
                    for (int i = 0; i < numEntries; i++){
                        System.out.println("-- " + entryList[i].name);
                        System.out.println("-- " + entryList[i].number);
                        System.out.println("-- " + entryList[i].notes);
                        System.out.println(" ");
                    }
                    break;
                case 'q':
                    quitCondition = 'q';
                    System.exit(0);
                    break;
            }
        }
    }

    public static void searchEntry(String search){
        int j = 0;

        for(int i = 0; i < numEntries; i++){
            if (entryList[i].name.contains(search)){
                System.out.println(entryList[i].name);
                System.out.println(entryList[i].number);
                System.out.println(entryList[i].notes);
                j++;
            }else {
                System.out.println("Search complete.");
                System.out.println("Found " + j + " matches.");
            }
        }
    }

    public static void WritePhoneBook(String f) throws Exception{
        PrintStream P = new PrintStream("C:\\Users\\Jonathan\\IdeaProjects\\Phonebook.java\\src\\entries.txt");

        for (int i = 0; i < numEntries; i++){
            P.println(entryList[i].name);
            P.println(entryList[i].number);
            P.println(entryList[i].notes);
        }
        P.close();
        System.out.println("Saved");
    }

    public static int readPhoneBook() throws FileNotFoundException {
        Scanner stdin = new Scanner(new File("C:\\Users\\Jonathan\\IdeaProjects\\Phonebook.java\\src\\entries.txt"));
        String name, number, notes;

        numEntries = 0;

        try {
            for (int i = 0; i < 200; i++) {
                name = stdin.nextLine();
                number = stdin.nextLine();
                notes = stdin.nextLine();
                entryList[i] = new Entry(name, number, notes);
                numEntries++;
            }
        }catch (Exception NoSuchElementException){
            System.out.println("Done");
            return numEntries;
        }
        return numEntries;

    }
}

