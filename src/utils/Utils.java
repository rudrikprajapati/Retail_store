package utils;

import java.io.Console;
import java.util.Scanner;

public class Utils {

    public static void print(String msg) {
        System.out.println(msg);
    }

    public static String hashedPassword() {
        Console console = System.console();
        String tempPass = "";
        if (console != null) {
            char tx[] = console.readPassword("Enter Password : ");
            tempPass = String.valueOf(tx);
            if (tempPass.length() != 0) {
                for (char c : tx) {
                    System.out.print("*");
                }
            }
            print("");
        }
        else
        {
            Scanner scanner = new Scanner(System.in);
            print("Enter Password : " );
            tempPass = scanner.nextLine();
        }
        return tempPass;
    }

    public static String userInputString(String t) {
        Scanner scanner = new Scanner(System.in);
        String data="";
        print("Please Enter "+ t +" : ");
        data = scanner.nextLine();
        return data;

    }

    public static int userInputInt(String t)
    {
        Scanner scanner = new Scanner(System.in);
        int no;
        print(t);
        no = Integer.parseInt(scanner.nextLine());
        return no;
    }

    public static double userInputDouble(String t)
    {
        Scanner scanner = new Scanner(System.in);
        double no;
        print(t);
        no = Double.parseDouble(scanner.nextLine());
        return no;
    }

    public static void clearTerminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}
