package com.challenge3;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    static final String DATA_SOURCE_PATH = "D:\\Abied\\Code\\Binar\\Challenge3\\challenge3\\res\\data_sekolah.csv";
    static final String DATA_OUTPUT_CLASS_PATH = "D:\\Abied\\Code\\Binar\\Challenge3\\challenge3\\res\\data_per_kelas.txt";
    static final String DATA_OUTPUT_SCHOOL_PATH = "D:\\Abied\\Code\\Binar\\Challenge3\\challenge3\\res\\data_sekolah.txt";
    static List<ClassData> classDataList = new ArrayList<>();
    static SchoolData schoolData = new SchoolData(classDataList);
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
                    writeFile(DATA_OUTPUT_CLASS_PATH);
                }
                    
                case 2 ->{
                    writeFile(DATA_OUTPUT_SCHOOL_PATH);
                }
                case 0 -> System.out.println("Terima kasih telah menggunakan aplikasi ini");
                default -> System.out.println("Menu tidak tersedia");
            }
            
        } while (menuChoice != 0);
    }
    public static void writeFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(fw);

            if(filename.equals(DATA_OUTPUT_CLASS_PATH)){
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

            }else if(filename.equals(DATA_OUTPUT_SCHOOL_PATH)){
                try {
                    bw.write("REKAP NILAI SEKOLAH");
                    bw.newLine();
                    bw.write("Mean: " + schoolData.getMean());
                    bw.newLine();
                    bw.write("Median: " + schoolData.getMedian());
                    bw.newLine();
                    bw.write("Modus: " + schoolData.getModus());
                    bw.newLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        
            
        
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
                String[] tokens = line.split(";");
                String className = tokens[0];
                List<Integer> classGrades = Arrays.stream(tokens)
                        .skip(1)
                        .map(data -> Integer.parseInt(data))
                        .collect(Collectors.toList());
                classDataList.add(new ClassData(className, classGrades));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return classDataList;
    }
}

