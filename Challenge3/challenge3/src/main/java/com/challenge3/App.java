package com.challenge3;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    final static String DATA_SOURCE_PATH = "D:\\Abied\\Code\\Binar\\Challenge3\\challenge3\\res\\data_sekolah.csv";
    final static String DATA_OUTPUT_CLASS_PATH = "D:\\Abied\\Code\\Binar\\Challenge3\\challenge3\\res\\data_per_kelas.txt";
    final static String DATA_OUTPUT_SCHOOL_PATH = "D:\\Abied\\Code\\Binar\\Challenge3\\challenge3\\res\\data_sekolah.txt";
    static List<ClassData> classDataList = new ArrayList<>();
    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        readFile();
        Scanner scanner = new Scanner(System.in);
        int menuChoice;
        String strip = "-".repeat(16);
        do {
            System.out.println(strip);
            System.out.println("Aplikasi Pengolah Nilai Siswa");
            System.out.println(strip);
            System.out.println("File telah digenerate");
            System.out.println("Pilih Menu");
            System.out.println("1. Generate txt Untuk Menampilkan Nilai Kelas");
            System.out.println("2. Generate txt Untuk Menampilkan Nilai Sekolah");
            System.out.println("0. Exit");
            System.out.print("Tentukan Pilihan : ");
            menuChoice = scanner.nextInt();

            switch (menuChoice) {
                case 1 ->{
                    readFile();
                    writeFile(DATA_OUTPUT_CLASS_PATH);
                }
                    
                case 2 ->{
                    readFile();
                    writeFile(DATA_OUTPUT_SCHOOL_PATH);
                }
                case 0 -> System.out.println("Terima kasih telah menggunakan aplikasi ini");
                default -> System.out.println("Menu tidak tersedia");
            }
            
        } while (menuChoice != 0);
    }

    public static void detailMenuFile() {
        
    }

    public static void writeFile(String filename) {
        try {
            if (filename == DATA_OUTPUT_CLASS_PATH) {
                classDataList.forEach(classData -> {
                    try {
                        FileWriter fw = new FileWriter(filename);
                        BufferedWriter bw = new BufferedWriter(fw);
                        bw.write("REKAP NILAI KELAS");
                        bw.newLine();
                        bw.write(classData.getClassName());
                        bw.newLine();
                        bw.write("Mean: " + classData.getMean());
                        bw.newLine();
                        bw.write("Median: " + classData.getMedian());
                        bw.newLine();
                        bw.write("Modus: " + classData.getModus());
                        bw.newLine();
                        bw.newLine();
                        bw.close();
                        fw.close();
                        System.out.println("Success Write File!");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
            } else if (filename == DATA_OUTPUT_SCHOOL_PATH) {
                FileWriter fw = new FileWriter(filename);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("REKAP NILAI SEKOLAH");
                bw.newLine();
                bw.write("Mean: " + SchoolData.getMean(classDataList));
                bw.newLine();
                bw.write("Median: " + SchoolData.getMedian(classDataList));
                bw.newLine();
                bw.write("Modus: " + SchoolData.getModus(classDataList));
                bw.newLine();
                bw.newLine();
                bw.close();
                fw.close();
                System.out.println("Success Write File!");
                
            }
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);
        
            classDataList.forEach(classData -> {
                try {
                    bw.write("REKAP NILAI KELAS");
                    bw.newLine();
                    bw.write(classData.getClassName());
                    bw.newLine();
                    bw.write("Mean: " + classData.getMean());
                    bw.newLine();
                    bw.write("Median: " + classData.getMedian());
                    bw.newLine();
                    bw.write("Modus: " + classData.getModus());
                    bw.newLine();
                    bw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        
            bw.close();
            fw.close();
            System.out.println("Success Write File!");
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<ClassData> readFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_SOURCE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");
                String className = split[0];
                List<Integer> classGrades = Arrays.stream(split)
                        .skip(1)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                ClassData classData = new ClassData(className, classGrades);
                classDataList.add(classData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classDataList;
    }
}

