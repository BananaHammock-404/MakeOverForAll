package pages;

import java.util.Scanner;

public class okeoke {

    Scanner s = new Scanner(System.in);
    String a = s.next();

    public static void kebalik(String b){
        for (int i = b.length() - 1; i >= 0; i--){
            System.out.print(b.charAt(i));
        }
    }

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a word: ");
        String  a= sc.next();
        kebalik(a);

    }


}
