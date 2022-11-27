package com.scifer.mihalis.models;

import lombok.*;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "students")
@Getter
@Setter
@ToString(callSuper = true)
public class Student extends User {
    private String interests;
}
