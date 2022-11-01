package com.mihalis.springtinder.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;

@Entity
@Table(name = "staffers")
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class Staffer extends User {

    @Column(nullable = false)
    private String position;

    @Column(name = "academic_degree")
    private String academicDegree;

    @Column(name = "academic_title")
    private String academicTitle;

    @Type(type = "list-array")
    @Column(name = "refs_to_qualifying_works", columnDefinition = "text[]")
    private ArrayList<String> refsToQualifyingWorks;
}
