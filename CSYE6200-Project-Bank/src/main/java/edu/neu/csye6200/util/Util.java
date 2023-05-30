package edu.neu.csye6200.util;


public class Util {

    public static StringBuilder getUniqueId() {
        StringBuilder id= new StringBuilder();
        for(int i=0;i<16;i++){
            id.append((int) (Math.random() * 10));
        }
        return id;
    }
}
