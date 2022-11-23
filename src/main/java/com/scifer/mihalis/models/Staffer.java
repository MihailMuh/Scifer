package com.scifer.mihalis.models;

import lombok.*;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "staffers")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Staffer extends User {
    private String position;

    @Column("academic_degree")
    private String academicDegree;

    @Column("academic_title")
    private String academicTitle;

    @Column("refs_to_qualifying_works")
    private String[] refsToQualifyingWorks;
}
