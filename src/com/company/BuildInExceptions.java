package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BuildInExceptions {



    public static void main(String[] args)  {
        // processInputException();
        //processIoException();
        //processDivideByZero();
        //processIndexOutOfBounds();
        //processClassNotFound();
        //processNoSuchMethod();
        //processNullPointer();

    }

    public static void processInputException() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        int a = 0;
        try {
            a = scanner.nextInt();
            System.out.println("a = " + a);

        } catch (InputMismatchException e) {
            //   e.printStackTrace();
            System.err.println("Неверный формат числа");

        }


    }

    public static void processIoException() {
        try {
            InputStream input = new FileInputStream("src/date/message.properties");
            System.out.println("File opened!");
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.err.println("File not found");
        }
    }

    public static void processDivideByZero() {
        int a = 1, b;
        try {
            b = a / 0;
        }
        catch (RuntimeException e){
            System.err.println("Нельзя делить на ноль");
        }
    }

    public static void processIndexOutOfBounds(){
        int[] a = {1,2,3};
        try {
            int b = a[3];
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("");
        }
    }
    public static void processClassNotFound() {
        try {
            Class.forName("com.company.BuildInExceptions");
        }
        catch (ClassNotFoundException e){
            System.err.println("not found class");
        }

    }

    public static void processNoSuchMethod() {
        TestClass testClass = new TestClass();
        Class<?> clas = testClass.getClass();
        try {
            Method method = clas.getDeclaredMethod("print");
            Field field = clas.getDeclaredField("i");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    public static void processNullPointer(){

        TestClass testClass = null;
        try {
            testClass.print();
        }
        catch (NullPointerException e){
            //e.printStackTrace();
            System.err.println("testClass is null");
        }

    }

}
class TestClass{
    private int i = 0;
    public void print(){
    }
}