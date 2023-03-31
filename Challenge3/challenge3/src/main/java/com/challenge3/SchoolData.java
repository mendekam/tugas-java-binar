package com.challenge3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SchoolData {
    
    private static List<ClassData> classDataList;

    public SchoolData(List<ClassData> classDataList) {
        this.classDataList = classDataList;
    }

    public double getMean() {
        int sum = 0;
        int count = 0;
        for (ClassData classData : classDataList) {
            List<Integer> grades = classData.getClassGrades();
            for (int grade : grades) {
                sum += grade;
                count++;
            }
        }
        return (double) sum / count;
    }

    public double getMedian() {
        List<Integer> allGrades = new ArrayList<>();
        for (ClassData classData : classDataList) {
            List<Integer> grades = classData.getClassGrades();
            for (int grade : grades) {
                allGrades.add(grade);
            }
        }
        int size = allGrades.size();
        Integer[] sortedGrades = allGrades.toArray(new Integer[size]);
        Arrays.sort(sortedGrades);
        if (size % 2 == 0) {
            int mid = size / 2;
            double median = (sortedGrades[mid - 1] + sortedGrades[mid]) / 2.0;
            return median;
        } else {
            int mid = size / 2;
            return sortedGrades[mid];
        }
    }

    public int getModus() {
        List<Integer> allGrades = new ArrayList<>();
        for (ClassData classData : classDataList) {
            List<Integer> grades = classData.getClassGrades();
            for (int grade : grades) {
                allGrades.add(grade);
            }
        }
        int maxCount = 0;
        int modus = -1;
        for (int grade : allGrades) {
            int count = 0;
            for (int g : allGrades) {
                if (g == grade) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                modus = grade;
            }
        }
        return modus;
    }
}
