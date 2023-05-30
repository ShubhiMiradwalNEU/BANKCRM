package edu.neu.csye6200.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

    public static void writeStringsToFile(List<String> lines, String fileName){

        try (
                FileWriter fw = new FileWriter(fileName);
                BufferedWriter out= new BufferedWriter(fw);

        ){

            System.out.println("Writing output to file " + fileName + " ...");
            for(String line: lines){
                System.out.print(line+"\n");
                out.write(line+"\n");
            }
            out.flush();

        } catch (IOException e) {
            System.out.println("Error Writing to file: "+e);
            
        }

    }

    public static List<String> readFileLines(String fileName){
        List<String> lines = new ArrayList<>();
        try (
                FileReader fr = new FileReader(fileName);
                BufferedReader in = new BufferedReader(fr);
        ){
            System.out.println("Reading File " + fileName + " ...");
            String currentLine;
            while ((currentLine = in.readLine()) != null) {
                System.out.println("Reading " + currentLine);
                lines.add(currentLine);
            }

        } catch (IOException e) {
            System.err.println("Error Reading file " + fileName);
            
        }
        return lines;
    }
}
