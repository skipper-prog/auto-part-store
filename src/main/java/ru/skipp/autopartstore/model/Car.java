package ru.skipp.autopartstore.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    @Column(name = "vin")
    @NotEmpty
    @Size(max = 128)
    private String vin;

    @Column(name = "release_date")
    private Date releaseDate;

    @ManyToOne
    @JoinColumn(name = "abstract_car_id")
    private AbstractCar abstractCar;

    @ManyToMany
    private List<Client> owners;

    public List<Client> getOwners() {
        return owners;
    }

    public void setOwners(List<Client> owners) {
        this.owners = owners;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public AbstractCar getAbstractCar() {
        return abstractCar;
    }

    public void setAbstractCar(AbstractCar abstractCar) {
        this.abstractCar = abstractCar;
    }

    public Car(){};

    public Car(String vin, Date releaseDate, AbstractCar abstractCar, List<Client> owners) {
        this.vin = vin;
        this.releaseDate = releaseDate;
        this.abstractCar = abstractCar;
        this.owners = owners;
    }
}
