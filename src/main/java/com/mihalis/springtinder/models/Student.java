package com.mihalis.springtinder.models;

import com.mihalis.springtinder.constants.UserTypes;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "students")
@Getter
@Setter
@ToString(callSuper = true)
public class Student extends User {
    private String interests;

    public Student() {
        setType(UserTypes.Student.ordinal());
    }
}
