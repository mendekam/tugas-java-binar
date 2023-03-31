package com.challenge3;
 
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.util.Arrays;
 
@ExtendWith(MockitoExtension.class)
class SchoolDataTest {
 
	ClassData classData;
	String DATA_SOURCE_PATH = "D:\\Abied\\Code\\Binar\\Challenge3\\challenge3\\res\\data_sekolah.csv";
	String DATA_OUTPUT_SCHOOL_PATH = "D:\\Abied\\Code\\Binar\\Challenge3\\challenge3\\res\\data_sekolah.txt";
	String DATA_OUTPUT_CLASS_PATH = "D:\\Abied\\Code\\Binar\\Challenge3\\challenge3\\res\\data_per_kelas.txt";
 
	@BeforeEach
	void prepare(){
		classData = new ClassData("XI MIPA 2", Arrays.asList(10,9,8,8,8,9,7,7,7,7));
	}
 
	@DisplayName("Success Test -> getModus()")
	@Test
	void testModusSuccess(){
		Assertions.assertEquals(7, classData.getModus());
	}
 
	@DisplayName("Failed Test -> getModus()")
	@Test
	void testModusFailed(){
		Assertions.assertNotEquals(7, classData.getModus());
	}
 
	@DisplayName("Success Test -> getMean()")
	@Test
	void testMeanSuccess(){
		Assertions.assertEquals(8.0,classData.getMean());
	}
 
	@DisplayName("Failed Test -> getMean()")
	@Test
	void testMeanFailed(){
		Assertions.assertNotEquals(10,classData.getMean());
	}
 
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
