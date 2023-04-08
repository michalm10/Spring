package ug.app.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Smartphone {
    private Long Id;
    private String id, model;
    private Imei imei;
    private Brand brand;

    @ManyToOne(cascade = CascadeType.ALL)
    public Brand getBrand() {
        return brand;
    }

    @OneToOne
    public Imei getImei() {
        return imei;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setImei(Imei imei) {
        this.imei = imei;
    }

    public void setId(Long id) {
        Id = id;
    }

    @ManyToMany(mappedBy="smartphones")
    public Collection<Users> getUsers() {
        return users;
    }

    public void setUsers(Collection<Users> users) {
        this.users = users;
    }

    private int storage, RAM;
    private Collection<Users> users;

    public Smartphone(){}

    public Smartphone(String id, String model, Brand brand, int storage, int RAM) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.storage = storage;
        this.RAM = RAM;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getIId() {
        return Id;
    }

    public void setIId(Long Id) {
        this.Id = Id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "Id=" + Id +
                ", id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", imei=" + imei +
                //", brand=" + brand +
                ", storage=" + storage +
                ", RAM=" + RAM +
                ", users=" + users +
                '}';
    }
}
