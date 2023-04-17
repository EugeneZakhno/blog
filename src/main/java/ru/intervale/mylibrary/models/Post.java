package ru.intervale.mylibrary.models;


import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Slf4j
@Data
@Component
@Table("POST")
public class Post {
    @Id
    private long id;
    private String title;
    private String anons;
    private String fulltext;
    private int views;

    public Post() {
    }

    public Post(String title, String anons, String fullText) {
        this.title = title;
        this.anons = anons;
        this.fulltext = fullText;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnons() {
        return anons;
    }

    public void setAnons(String anons) {
        this.anons = anons;
    }

    public String getFullText() {
        return fulltext;
    }

    public void setFullText(String fullText) {
        this.fulltext = fullText;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }


}
