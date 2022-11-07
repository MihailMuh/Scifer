package com.mihalis.springtinder.models;

import com.mihalis.springtinder.constants.UserType;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.ArrayList;

@TypeDef(name = "list-array", typeClass = ListArrayType.class)
@MappedSuperclass
@NoArgsConstructor
@Getter
@Setter
@ToString
public abstract class User {
    @Id
    private long id;


    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String patronymic;


    private String photo;

    @Column(name = "photo_rec")
    private String photoRec;


    @Column(nullable = false)
    private String hash;

    @Column(nullable = false, name = "access_token")
    private String accessToken;


    @Column(nullable = false)
    private String specialization;


    @Type(type = "list-array")
    @Column(nullable = false, name = "refs_to_articles", columnDefinition = "text[]")
    private ArrayList<String> refsToArticles;


    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType type;
}
