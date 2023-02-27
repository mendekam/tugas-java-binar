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
        System.out.println("2. Cek Jenis Alphabet");
        System.out.print("Pilih: "); int pilihanMenu = scanner.nextInt();

        scanner.nextLine();
        System.out.println("Masukkan Kata : "); kata = scanner.nextLine();

        if (pilihanMenu == 1) {
            cekPalindrome(kata);
        } else if (pilihanMenu == 2){
            cekAlphabet(kata);
        }
    }

    public static void cekPalindrome(String str) {
        String reverseStr = "";
        str = str.toLowerCase();
    
        int strLength = str.length();
    
        for (int i = (strLength - 1); i >= 0; --i) {
            reverseStr = reverseStr + str.charAt(i);
        }
    
        if (str.toLowerCase().equals(reverseStr.toLowerCase())) {
            System.out.println(str + " adalah Palindrome");
        }
        else {
            System.out.println(str + " bukan Palindrome");
        }
        
    }

    public static void cekAlphabet(String sentence) {
        int countConsonant = 0;
        int countSpace = 0;
        int countVocal = 0;
        int countSymbol = 0;
        int countLetter = 0;

        for (int i=0 ; i<sentence.length(); i++){
            char ch = sentence.charAt(i);
            if(sentence.substring(i, i+1).matches("[aeiouAEIOU]")){
                countVocal++;
            }else if(!sentence.substring(i, i+1).matches("[aeiouAEIOU]") && !sentence.substring(i, i+1).matches("[^A-Za-z0-9]")){
                countConsonant++;
            }else if(ch == ' '){
                countSpace++;
            }else if(sentence.substring(i, i+1).matches("[^A-Za-z0-9]")){
                countSymbol++;
            }
            countLetter++;
        }
        System.out.println("Total Karakter ada : " + countLetter);
        System.out.println("Alfabet konsonan ada : "+ countConsonant);
        System.out.println("Alfabet vocal ada : "+ countVocal);
        System.out.println("Spasi ada : "+ countSpace);
        System.out.println("Simbol ada : "+ countSymbol);

    }
}