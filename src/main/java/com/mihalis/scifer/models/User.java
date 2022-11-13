package com.mihalis.scifer.models;

import com.mihalis.scifer.constants.UserType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Data
public abstract class User implements Persistable<Long> {
    @Id
    private Long id;

    private String name;
    private String surname;
    private String patronymic;

    @Column("photo_rec")
    private String photoRec;
    private String photo;

    @Column("access_token")
    private String accessToken;
    private String hash;

    private String specialization;

    @Column("refs_to_articles")
    private String[] refsToArticles;

    private UserType type;

    @Column("register_date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime registerDate;

    @Override
    @NonNull
    public Long getId() {
        return id;
    }

    @Override
    @Transient
    public boolean isNew() {
        if (registerDate == null) {
            registerDate = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS);
            return true;
        }
        return false;
    }
}
