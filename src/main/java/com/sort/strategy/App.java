package com.sort.strategy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {
    private static final int NUM_OF_EMPLOYEES = 200000;
    private static final char SORT_ORDER = 'A';


    public static void main(String[] args) {

        createFileWithNames();
        File log = new File("log.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(log);

            ArrayList<String> arrList = new ArrayList<>();
            while(sc.hasNextLine()){
                arrList.add(sc.nextLine());
            }
            String[] actualNames = new String[arrList.size()];
            arrList.toArray(actualNames);


            String algorithm = null;
            Context c = null;
            if (NUM_OF_EMPLOYEES < 11000) {
                algorithm = "BUBBLE SORT";
                c = new Context(new BubbleSort());
            }else {
                algorithm = "QUICK SORT";
                c = new Context( new QuickSort());
            }
            long start = System.currentTimeMillis();
            c.arrange(actualNames, SORT_ORDER);
            long end = System.currentTimeMillis();
            printNames(actualNames);
            System.out.println(NUM_OF_EMPLOYEES + " names are sorted using " + algorithm +" algorithm.");
            System.out.println("In " + (end - start) + " milliseconds.");

        } catch (FileNotFoundException e){
            System.out.println(e);
        }
        finally {
            sc.close();
        }
	}
		
    public static void printNames(String[] names) {
        System.out.println("-------");
        for ( final String name : names) {
            System.out.println(name);
        }
    }
    private static void createFileWithNames() {
        File log = new File("log.txt");
        PrintWriter logWriter = null;
        try {
            logWriter = new PrintWriter(log);
            for (int i = 0; i < NUM_OF_EMPLOYEES; i++) {
                logWriter.write(getString());
                logWriter.write("\n");

            }
        } catch(FileNotFoundException e){
            System.out.println(e);
        }
        finally {
            logWriter.close();
        }
    }
    private static String  getString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) { // length of the random string.
            int index =  rnd.nextInt(SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

}