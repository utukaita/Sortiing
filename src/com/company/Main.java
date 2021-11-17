package com.company;
import ibcsutils.ReadViaURL;

// Array algorithms, not just sorting, as the name clearly indicates

public class Main {

    public static void main(String[] args) {
	    // Sorting
        int [] numbers = {5, 7, 3, -2, 0, 1, 10, -10};
	    for (int i = 0; i < numbers.length-1; i++) {
            int smallest_index = i;
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[j] < numbers[smallest_index])
                    smallest_index=j;
            }
            int a = numbers[i];
            numbers[i] = numbers[smallest_index];
            numbers[smallest_index] = a;
	    }
        for (int k:numbers)
            System.out.print(k + " ");
        // Homework 2
        String [] students = {"Alissa", "Ben", "Charlie", "Dianna"};
        char [] grades = {'B', 'D', 'B', 'A'};
        String daName = "Charlie";
        boolean searching = true;
        int num = 0;
        for (int i = 0; i < students.length && searching == true; i++) {
            if (students[i].equals(daName)){
                num = i;
                searching = false;
            }
        }
        System.out.println("");
        System.out.println(grades[num]);
        // Homework 4:
        System.out.println(izWord("http://www-personal.umich.edu/~jlawler/wordlist", "zu"));
    }
    static boolean izWord(String address, String word){
        // to read, to remove puctuation and digits, to lowercase
        String[] words = ReadViaURL.readWords (address, true, true, true);
        for (String i : words) {
            if (i.compareTo(word)==1)
                return true;
        }
        return false;
    }
}