package com.company;
import ibcsutils.ReadViaURL;

import java.util.Random;

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
        //System.out.println(izWord("http://www-personal.umich.edu/~jlawler/wordlist", "zu"));
        //System.out.println(binarySearch("http://www-personal.umich.edu/~jlawler/wordlist", "zu"));
        // S'more
        int[] array = {7,9,11,2};
        boolean changed = true;
        while(changed){
            changed = false;
            for (int i = 0; i < array.length-1; i++) {
                if (array[i]>array[i+1]){
                    int a = array[i];
                    array[i] = array[i+1];
                    array[i+1] = a;
                    changed = true;
                }
            }
        }
        for(int i: array)
            System.out.print(i + " ");
        // Homework 5
        int [] nums = {9, 7, 2, 11};
        int k = 1;
        while (k<nums.length){
            int val = nums[k];
            int l = k-1;
            while (l >= 0 && nums[l] > val){
                nums[l+1] = nums[l];
                l--;
            }
            nums[l+1] = val;
            k++;
        }
        System.out.println("");
        for(int n : nums)
            System.out.print(n + " ");
        // Homework 7
        String [] random_list = randomSuffle("http://www-personal.umich.edu/~jlawler/wordlist");
        for(String n : random_list)
            System.out.println(n);
        for(int i = 0; i < random_list.length-1; i++){
            int smallest_index = i;
            for(int j = i+1; j < random_list.length; j++){
                if (random_list[j].compareTo(random_list[smallest_index])<0)
                    smallest_index = j;
            }
            String a = random_list[i];
            random_list[i] = random_list[smallest_index];
            random_list[smallest_index] = a;
        }
        for(String n : random_list)
            System.out.println(n);
        // Running time only 10 s including the previous parts which took some milliseconds

    }
    static boolean izWord(String address, String word){
        // to read, to remove puctuation and digits, to lowercase
        String[] words = ReadViaURL.readWords (address, true, true, true);
        for (String i : words) {
            if (i.compareTo(word)==0)
                return true;
        }
        return false;
    }
    static boolean binarySearch(String address, String word){
        // to read, to remove punctuation and digits, to lowercase
        String[] words = ReadViaURL.readWords (address, true, true, true);
        int lo = 0, hi = words.length-1;
        while(hi>=lo){
            int mid = (lo+hi)/2;
            String midpoint = words[mid];
            if (midpoint.compareTo(word)==0)
                return true;
            else if (midpoint.compareTo(word)>0)
                hi = mid-1;
            else
                lo = mid+1;
        }
        return false;
    }
    static String [] randomSuffle(String address) {
        // to read, to remove puctuation and digits, to lowercase
        String[] words = ReadViaURL.readWords(address, true, true, true);
        Random random = new Random();
        for (int i = 0; i < words.length; i++) {
            int random_number = random.nextInt(words.length - 1);
            String saved_word = words[i];
            words[i] = words[random_number];
            words[random_number] = saved_word;
        }
        return words;
    }

}