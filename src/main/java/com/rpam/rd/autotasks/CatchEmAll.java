package com.rpam.rd.autotasks;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CatchEmAll {

    //You may set another exception in this field;
    public static Exception exception = null;



    public static void riskyMethod() throws Exception {
        if (exception != null) {
            throw exception;
        }
    }


    public static void main(String[] args) throws Exception {
        if (args.length >= 1) {
            switch (args[0]) {
                case "IOException":
                    exception = new IOException();
                    break;
                case "FileNotFoundException":
                    exception = new FileNotFoundException();
                    break;
                case "ArithmeticException":
                    exception = new ArithmeticException();
                    break;
                case "NumberFormatException":
                    exception = new NumberFormatException();
                    break;
            }
        }

        try {
            riskyMethod();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Resource is missing", e);
        } catch (IOException e) {
            throw new IllegalArgumentException("Resource error", e);
        } catch (ArithmeticException|NumberFormatException e) {

            System.err.print(e.getMessage());
        }
    }
}
