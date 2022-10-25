package com.mihalis.springtinder.models;

import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.ArrayList;

@TypeDef(
        name = "list-array",
        typeClass = ListArrayType.class
)

@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
@ToString
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name, surname, patronymic;
    private String specialization;

    @Type(type = "list-array")
    @Column(
            name = "refs_to_articles",
            columnDefinition = "text[]"
    )
    private ArrayList<String> refsToArticles;

    private int type;
}
