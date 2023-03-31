package com.challenge3;

import java.io.File;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FileTest {
    String DATA_SOURCE_PATH = "D:\\Abied\\Code\\Binar\\Challenge3\\challenge3\\res\\data_sekolah.csv";
	String DATA_OUTPUT_SCHOOL_PATH = "D:\\Abied\\Code\\Binar\\Challenge3\\challenge3\\res\\data_sekolah.txt";
	String DATA_OUTPUT_CLASS_PATH = "D:\\Abied\\Code\\Binar\\Challenge3\\challenge3\\res\\data_per_kelas.txt";

    @DisplayName("Success Test -> Success check given path name is file")
	@Test
	void isFileTest() {
		File file = new File(DATA_OUTPUT_SCHOOL_PATH);
		Assertions.assertTrue(file.isFile());
	}
 
	@DisplayName("Success Test -> Success read file")
	@Test
	void pathFileTest() {
		File file = new File(DATA_OUTPUT_SCHOOL_PATH);
		Assertions.assertTrue(file.getAbsolutePath().endsWith("data_sekolah.txt"));
	}
}
