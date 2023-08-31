package uz.crud.crudinstructor.entity;

import lombok.Data;

@Data
public class MarkStudentSum {
    private int markedStudentSum;
    private int maxStudent;

    public MarkStudentSum(int markedStudentSum, int maxStudent) {
        this.markedStudentSum = markedStudentSum;
        this.maxStudent = maxStudent;
    }
}
