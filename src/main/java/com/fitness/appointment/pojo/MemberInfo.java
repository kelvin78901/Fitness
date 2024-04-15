package com.fitness.appointment.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Member.java
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberInfo {
    private int id;
    private String name;
    private String gender;
    private String phone;
    private int age;

}
