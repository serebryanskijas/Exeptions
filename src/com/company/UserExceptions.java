package com.company;
import static java.lang.Character.isLowerCase;
import java.util.Scanner;
/*
Реализовать метод возвращающий время года (зима|весна|лето|осень) по номеру месяца.
Месяца номеруются с 1 до 12. Январь - 1, Декабрь - 12.
В случае если в аргументе monthNumber будет недопустимое число,
метод должен кидать исключение IllegalArgumentException с сообщение вида
"monthNumber=-5 is invalid, the number of a month should be in a range of 1..12"
 */

public class UserExceptions {
    public static void main(String[] args) throws NotEvenException, NotNumberException, Person.NotCapitalException {
        Scanner scanner = new Scanner(System.in);
        //System.out.println("Enter an even number: ");
        //int a = scanner.nextInt();
      //  System.out.println("введите число от 1 до 10 включительно");
     //   int b = scanner.nextInt();
        // validateEven(a);
       // validate(b);
        //System.out.println("Enter your name");
        //String s = scanner.nextLine();
       // Person person = new Person(s);
        Person.getCaller();


    }

    public static void validateEven(int number) throws NotEvenException {
        if (number % 2 != 0) {
            throw new NotEvenException("Веденное число не четное");
        }
    }

    public static void validate(int number) throws NotNumberException {
        if (number < 1 || number > 10) {
            throw new NotNumberException("Веденное число не в диапазоне от 1 до 10");
        }
    }


}

class NotEvenException extends Exception {

    public NotEvenException(String message) {
        super(message);
    }
}

class NotNumberException extends Exception {

    public NotNumberException(String message) {
        super(message);
    }
}

class Person{

    private String name ="";

    public Person(String name) throws NotCapitalException {
        this.name = name;
        validateName(name);

    }

    private void validateName(String name) throws NotCapitalException {
        if (isLowerCase(name.charAt(0)))
            throw new NotCapitalException("The first letter of name "+name+" must be capital");
    }

    class NotCapitalException extends Exception{
        public NotCapitalException(String message) {
            super(message);
        }
    }

   public static void getCaller(){
        Exception e = new Exception();
        String className = e.getStackTrace()[1].getClassName();
       System.out.println(className);
       String methodName = e.getStackTrace()[1].getMethodName();
       System.out.println(methodName);
       int line = e.getStackTrace()[1].getLineNumber();
       System.out.println(line);
    }
}


//Вывести в консоль имя вызывающего его класса и метода (раскручивание стека вызовов).

