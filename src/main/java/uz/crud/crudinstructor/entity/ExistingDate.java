package uz.crud.crudinstructor.entity;

import lombok.Data;

@Data
public class ExistingDate {
    private String date;
    private Boolean present;

    public ExistingDate(String date, Boolean present) {
        this.date = date;
        this.present = present;
    }

    public ExistingDate() {
    }
}
/*
[

 {
  date:2023-08-22,
  absent:true,
  presentfalse
 },
  {
  date:2023-08-22,
  absent:true,
  presentfalse
 },


 ]

 */
