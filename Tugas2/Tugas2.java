package Tugas2;

import java.util.Scanner;

/**
 * Tugas2
 */
public class Tugas2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String kata = "";
        System.out.println("1. Cek Palindrome");
        System.out.println("2. Cek Alphabet");
        System.out.print("Pilih: "); int pilihanMenu = scanner.nextInt();

        System.out.println("Masukkan Kata : "); kata = scanner.next();
        
        if (pilihanMenu == 1) {
            cekPalindrome(kata);
        }
    }

    public static String cekPalindrome(String str) {
        String reverseStr = "";
        str = str.toLowerCase();
    
        int strLength = str.length();
    
        for (int i = (strLength - 1); i >=0; --i) {
            reverseStr = reverseStr + str.charAt(i);
        }
    
        if (str.toLowerCase().equals(reverseStr.toLowerCase())) {
            System.out.println(str + " adalah Palindrome");
        }
        else {
            System.out.println(str + " bukan Palindrome");
        }

        return "";
        
    }
}