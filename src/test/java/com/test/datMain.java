package com.test;

import com.dat.DATrie;

import java.io.*;
import java.util.ArrayList;

public class datMain {

    public static void main(String[] args) throws IOException {
        // Step one: build words set
        ArrayList<String> words = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/test.txt")));
        String temp;
        while((temp = reader.readLine())!=null){
            words.add(temp);
        }

        // Step two: build dat
        DATrie dat = new DATrie(DATrie.InitType.Empty);
        for(String word : words)
            dat.add(word);

        // Step three: check word
        System.out.println(dat.contains("敏感")+" "+dat.contains("敏感地带") +" "+dat.contains("晓峰"));
        System.out.println(dat.maxMatch("敏感", 1));
    }
}
