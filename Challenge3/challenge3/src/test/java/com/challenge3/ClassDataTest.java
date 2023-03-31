package com.challenge3;
 
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
 
@ExtendWith(MockitoExtension.class)
class ClassDataTest {
 
	ClassData classData;
 
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
		Assertions.assertNotEquals(8, classData.getModus());
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

	@DisplayName("Success Test -> getMedian()")
	@Test
	void testMedianSuccess(){
		Assertions.assertEquals(8.0,classData.getMedian());
	}

	@DisplayName("Failed Test -> getMedian()")
	@Test
	void testMedianFailed(){
		Assertions.assertNotEquals(10,classData.getMedian());
	}

 
 
}
