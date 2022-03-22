package com.fis.test;

public interface IA {
    public default void printItem(){
        System.out.println("IA");
    }
}
