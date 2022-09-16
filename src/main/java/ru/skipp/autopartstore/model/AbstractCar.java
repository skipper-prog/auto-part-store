package ru.skipp.autopartstore.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "abstract_cars")
public class AbstractCar extends BaseEntity {

    @Column(name = "title")
    private String title;
    @Column(name = "short_title")
    private String shortTitle;

    public AbstractCar(Long id, String title, String shortTitle) {
        super(id);
        this.title = title;
        this.shortTitle = shortTitle;
    }

    public AbstractCar() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }
}
