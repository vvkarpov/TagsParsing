package ru.vkarpov.dev;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Study task - Tag parsing
*/

public class Solution {

    public static String filename = null;
    public static String tag;
    public static StringBuilder string = new StringBuilder();

    public static void main(String[] args) throws IOException {

        tag = args[0];

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            filename = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        readFile(filename);//Read file
        //System.out.println(string + "\n");//Line from file
        parsing(string.toString(), tag);
    }

    public static void readFile (String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){//
            while (reader.ready()){
                string.append(reader.readLine());
            }
        }
    }

    public static void parsing(String line, String tag){

        Pattern pattern = Pattern.compile("<" + tag + "\\s.+?<\\/" + tag + ">.+?<\\/" + tag + ">");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()){
            System.out.println(matcher.group());
        }
        Pattern pattern2 = Pattern.compile("<" + tag + ">.+?<\\/" + tag + ">");
        Matcher matcher2 = pattern2.matcher(line);
        while (matcher2.find()){
            System.out.println(matcher2.group());
        }
    }

}
