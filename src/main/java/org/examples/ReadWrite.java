package org.examples;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadWrite {


    public String readFile(String path) {
        String content = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            String line = br.readLine();
            while (line != null) {
                content += line + "\n";
                line = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error: file could not be read");
        }
//        System.out.println(content);
        return content;
    }

}