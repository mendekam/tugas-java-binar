package com.challenge3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ClassData {
    private String className;
    private List<Integer> classGrades;

    public ClassData(String className, List<Integer> classGrades) {
        this.className = className;
        this.classGrades = classGrades;
    }

    public String getClassName() {
        return className;
    }

    public List<Integer> getClassGrades() {
        return classGrades;
    }

    public double getMean() {
        return classGrades.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(Double.NaN);
    }

    public double getMedian() {
        List<Integer> sortedGrades = new ArrayList<>(classGrades);
        Collections.sort(sortedGrades);
        int middle = sortedGrades.size() / 2;
        if (sortedGrades.size() % 2 == 0) {
            double left = sortedGrades.get(middle - 1);
            double right = sortedGrades.get(middle);
            return (left + right) / 2.0;
        } else {
            return sortedGrades.get(middle);
        }
    }

    public int getModus() {
        Map<Integer, Integer> countMap = new HashMap<>();
        int maxCount = 0;
        int modus = Integer.MIN_VALUE;
        for (int grade : classGrades) {
            int count = countMap.getOrDefault(grade, 0) + 1;
            countMap.put(grade, count);
            if (count > maxCount) {
                maxCount = count;
                modus = grade;
            }
        }
        return modus;
    }
}