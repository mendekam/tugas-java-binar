package Challenge1;

import java.util.Scanner;

public class Challenge1 {
    private static Scanner scannerInt = new Scanner(System.in);
    private static Scanner scannerStr = new Scanner(System.in);
    public static void main(String[] args) {
        
        menu();

    }

    public static void menu() {
        System.out.println("==================================");
        System.out.println("PROGRAM MENGHITUNG LUAS DAN VOLUME");
        System.out.println("==================================");
        System.out.println("Menu \n1. Hitung Luas Bidang \n2. Hitung Volume \n0. Tutup Aplikasi");
        System.out.println("Pilih Menu : ");
        int inputMenu = scannerInt.nextInt();
        System.out.println("==================================");


        if (inputMenu == 1) {
            System.out.println("==================================");
            System.out.println("PILIH BIDANG YANG AKAN DIHITUNG");
            System.out.println("==================================");
            System.out.println("1. Persegi \n2. Lingkaran \n3. Segitiga \n4. Persegi Panjang \n 0. Kembali ke Menu Sebelumnya");
            int inputMenuLuas = scannerInt.nextInt();
            
            switch (inputMenuLuas) {
                case 1:
                    luasPersegi();
                    break;
                
                case 2:
                    luasLingkaran();
                    break;

                case 3:
                    luasSegitiga();
                    break;

                case 4:
                    luasPersegiPanjang();
                    break;

                default:
                    menu();
                    break;
            }
        } else if(inputMenu == 2){
            System.out.println("==================================");
            System.out.println("PILIH BIDANG YANG AKAN DIHITUNG");
            System.out.println("==================================");
            System.out.println("1. Kubus \n2. Balok \n3. Tabung \n0. Kembali ke Menu Sebelumnya");
            int inputMenuVolume = scannerInt.nextInt();

            switch (inputMenuVolume) {
                case 1:
                    volumeKubus();
                    break;
                
                case 2:
                    volumeBalok();
                    break;

                case 3:
                    volumeTabung();
                    break;

                default:
                    menu();
                    break;
            }
            
        }
        
    }

    public static void luasPersegiPanjang() {
        System.out.println("==================================");
        System.out.println("ANDA MEMILIH PERSEGI PANJANG");
        System.out.println("==================================");

        System.out.println("Masukkan Panjang : ");
        int a = scannerInt.nextInt();
        System.out.println("Masukkan lebar : ");
        int b = scannerInt.nextInt();

        System.out.println("Luas Persegi Panjang adalah " +a*b);
        System.out.println("==================================");
        System.out.println("Tekan apa saja untuk kembali ke menu utama");
        boolean kembali = scannerStr.hasNext();
        if (kembali) {
            menu();
        }
    }

    public static void luasPersegi() {
        System.out.println("==================================");
        System.out.println("ANDA MEMILIH PERSEGI");
        System.out.println("==================================");

        System.out.println("Masukkan Panjang Sisi : ");
        int a = scannerInt.nextInt();

        System.out.println("Luas Persegi adalah " +a*a);
        System.out.println("==================================");
        System.out.println("Tekan apa saja untuk kembali ke menu utama");
        boolean kembali = scannerStr.hasNext();
        if (kembali) {
            menu();
        }
    }

    public static void luasSegitiga() {
        System.out.println("==================================");
        System.out.println("ANDA MEMILIH Segitiga");
        System.out.println("==================================");

        System.out.println("Masukkan Lebar Alas : ");
        int a = scannerInt.nextInt();
        System.out.println("Masukkan Tinggi : ");
        int b = scannerInt.nextInt();

        System.out.println("Luas Segitiga adalah " +a*b/2);
        System.out.println("==================================");
        System.out.println("Tekan apa saja untuk kembali ke menu utama");
        boolean kembali = scannerStr.hasNext();
        if (kembali) {
            menu();
        }
    }

    public static void luasLingkaran() {
        final double PI = 3.14;
        System.out.println("==================================");
        System.out.println("ANDA MEMILIH LINGKARAN");
        System.out.println("==================================");

        System.out.println("Masukkan Jari-Jari : ");
        int a = scannerInt.nextInt();

        System.out.println("Luas Lingkaran adalah " +a*a*PI);
        System.out.println("==================================");
        System.out.println("Tekan apa saja untuk kembali ke menu utama");
        boolean kembali = scannerStr.hasNext();
        if (kembali) {
            menu();
        }
    }
    
    public static void volumeKubus() {
        System.out.println("==================================");
        System.out.println("ANDA MEMILIH KUBUS");
        System.out.println("==================================");

        System.out.println("Masukkan Sisi : ");
        int a = scannerInt.nextInt();

        System.out.println("Volume Kubus adalah " +a*a*a);
        System.out.println("==================================");
        System.out.println("Tekan apa saja untuk kembali ke menu utama");
        boolean kembali = scannerStr.hasNext();
        if (kembali) {
            menu();
        }
    }

    public static void volumeBalok() {
        System.out.println("==================================");
        System.out.println("ANDA MEMILIH TABUNG");
        System.out.println("==================================");

        System.out.println("Masukkan Panjang : ");
        int a = scannerInt.nextInt();
        System.out.println("Masukkan Lebar : ");
        int b = scannerInt.nextInt();
        System.out.println("Masukkan Tinggi : ");
        int c = scannerInt.nextInt();

        System.out.println("Volume Balok adalah " +a*b*c);
        System.out.println("==================================");
        System.out.println("Tekan apa saja untuk kembali ke menu utama");
        boolean kembali = scannerStr.hasNext();
        if (kembali) {
            menu();
        }
    }

    public static void volumeTabung() {
        final double PI = 3.14;
        System.out.println("==================================");
        System.out.println("ANDA MEMILIH TABUNG");
        System.out.println("==================================");

        System.out.println("Masukkan Jari-Jari : ");
        int a = scannerInt.nextInt();
        System.out.println("Masukkan Tinggi : ");
        int b = scannerInt.nextInt();

        System.out.println("Volume Balok adalah " +a*b*PI);
        System.out.println("==================================");
        System.out.println("Tekan apa saja untuk kembali ke menu utama");
        boolean kembali = scannerStr.hasNext();
        if (kembali) {
            menu();
        }
    }
    
}
