package uz.crud.crudinstructor.entity;

import lombok.Data;

@Data
public class PresentStudent {
    private Boolean present = true;
    private InClass inClass;

    public PresentStudent(InClass inClass) {
        this.inClass = inClass;
    }
}
