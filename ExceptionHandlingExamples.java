package work2;



import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class ExceptionHandlingExamples {

    public static void handleArithmeticException() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nExample: ArithmeticException");
        try {
            System.out.print("Enter a number to divide 8 by: ");
            int divisor = scanner.nextInt();
            // Attempt a division by user input
            int result = 8/ divisor;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero.");
        }
    }

    public static void handleNullPointerException() {
        System.out.println("\nExample: NullPointerException");
        try {
            String str = null;
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("Tried to access something on a null object.");
        }
    }


    public static void handleArrayIndexOutOfBoundsException() {
        System.out.println("\nExample: ArrayIndexOutOfBoundsException");
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter an index to access in an array of size 3: ");
            int index = scanner.nextInt();
            int[] numbers = {4, 5, 6};
            System.out.println("Element: " + numbers[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index used for the array.");
        }
    }

    // ClassCastException Example
    public static void handleClassCastException() {
        System.out.println("\nExample: ClassCastException");
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter an integer to cast to a string: ");
            int number = scanner.nextInt();
            String str = (String) (Object) number; // Invalid cast
        } catch (ClassCastException e) {
            System.out.println("Tried to cast an incompatible type.");
        }
    }


    public static void handleIllegalArgumentException() {
        System.out.println("\nExample: IllegalArgumentException");
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a negative number for age: ");
            int age = scanner.nextInt();
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be negative.");
            }
            System.out.println("Age is: " + age);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }


    public static void handleNumberFormatException() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nExample: NumberFormatException");
        try {
            System.out.print("Enter a number to parse: ");
            String input = scanner.nextLine();
            int number = Integer.parseInt(input);
            System.out.println("Parsed number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Invalid format for number conversion.");
        }
    }

    // IOException Example
    public static void handleIOException() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nExample: IOException");
        try {
            System.out.print("Enter a file name to open: ");
            String filename = scanner.nextLine();
            FileInputStream file = new FileInputStream(filename);
        } catch (IOException e) {
            System.out.println("Input/Output error: " + e.getMessage());
        }
    }


    public static void handleFileNotFoundException() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nExample: FileNotFoundException");
        try {
            System.out.print("Enter a file name to open: ");
            String filename = scanner.nextLine();
            FileInputStream file = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    // EOFException Example
    public static void handleEOFException() {
        System.out.println("\nExample: EOFException");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.txt"))) {
            // Attempt to read beyond the end of the file
            Object obj = ois.readObject();
            System.out.println(obj);
        } catch (EOFException e) {
            System.out.println("Reached the end of the file unexpectedly.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // SQLException Example
    public static void handleSQLException() {
        System.out.println("\nExample: SQLException");
        try {
            // Simulate a database connection failure or SQL error
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nonexistentdb", "user", "password");
            Statement stmt = conn.createStatement();
            stmt.executeQuery("SELECT * FROM users");
        } catch (SQLException e) {
            System.out.println("A database error occurred: " + e.getMessage());
        }
    }


    public static void handleClassNotFoundException() {
        System.out.println("\nExample: ClassNotFoundException");
        try {

            Class.forName("com.nonexistent.Class");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Demonstrating Exceptions:");


        handleArithmeticException();
        handleNullPointerException();
        handleArrayIndexOutOfBoundsException();
        handleClassCastException();
        handleIllegalArgumentException();
        handleNumberFormatException();

       
        handleIOException();
        handleFileNotFoundException();
        handleEOFException();
        handleSQLException();
        handleClassNotFoundException();
    }
}

