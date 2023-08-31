package uz.crud.crudinstructor.entity;

import lombok.Data;

@Data
public class ExistingProsent {
    private int maxStudents;
    private int presentcount;
    private int absentcount;

    public ExistingProsent(int maxExisting, int presentcount, int absentcount) {
        this.maxStudents = maxExisting;
        this.presentcount = presentcount;
        this.absentcount = absentcount;
    }

    public ExistingProsent() {
    }
}
