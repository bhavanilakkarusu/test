package com.yatra;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
	
	// Complete the isValid function below.
    static String isValid(String s) {
        int a[]=new int[26];
        for(int i=0;i<s.length();i++){
            a[s.charAt(i)-'a']++;
        }
        Integer first,second;
        first=null;
        int firstOccurences=0;
        int secondOccurences=0;
        second=null;
        Boolean isValid=true;
        for(int i=0;i<a.length;i++){
            if(a[i]==0) continue;
            if(first==null){
                first=a[i];
                firstOccurences=1;
                continue;
            }
            else if(first==a[i] ){
                firstOccurences++;
                continue;
            }else if (second==null){
              secondOccurences=1;
               second=a[i];
                continue;
            }else if (second==a[i]){
                secondOccurences++;
            continue;
           }
           isValid=false;
           break;
        }
        if(!isValid){
            return "NO";
        }
        if(second==null){
            return "YES";
        }
        if (first==1 && firstOccurences==1){
           return  "YES";
        }
        if(second==1 && secondOccurences==1){
        	return "YES";
        }
        if(first>second){
            if(first-second == 1 && firstOccurences==1){
                return "YES";
            }
        }else if( second-first==1 && secondOccurences==1){
            return "YES";
        }
        return "NO";
        
        


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();*/
    	String result=isValid("aabbcd");

        scanner.close();
    }

}
