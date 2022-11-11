package com.mihalis.scifer.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class Student extends User {

    @Column(nullable = false)
    private String interests;
}
