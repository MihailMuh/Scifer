package com.scifer.mihalis.models;

import com.scifer.mihalis.constants.UserType;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class User implements Persistable<Long> {
    @Id
    private long id;

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
    private LocalDate registerDate;

    @Override
    @NonNull
    public Long getId() {
        return id;
    }

    @Override
    public boolean isNew() {
        if (registerDate == null) {
            registerDate = LocalDateTime.now().toLocalDate();
            return true;
        }
        return false;
    }
}
