package ru.skipp.autopartstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client extends BaseEntity {

    @Column(name = "first_name")
    @Size(max = 30)
    private String firstName;

    @Column(name = "second_name")
    @NotEmpty
    @Size(max = 30)
    private String secondName;

    @Column(name = "patronymic")
    @Size(max = 30)
    private String patronymic;

    @Column(name = "tel")
    @Size(max = 15)
    private String tel;

    @ManyToMany
    private List<Car> garage;

//    public String GetCarsList(){
//        garage.toString()
//        return
//    }

    public List<Car> getGarage() {
        return garage;
    }

    public void setGarage(List<Car> garage) {
        this.garage = garage;
    }

    public Client(String firstName, String secondName, String patronymic, String tel, List<Car> garage) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.tel = tel;
        this.garage = garage;
    }

    public Client() {}

    public String fio(){
        return String.format("%s %s %s", secondName, firstName, patronymic);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void clone(Client clientNew) {
        firstName = clientNew.firstName;
        secondName = clientNew.secondName;
        patronymic = clientNew.patronymic;
        tel = clientNew.tel;
    }
}
