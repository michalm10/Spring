package ug.app.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Imei {
    private String imei;
    private int Id;

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return Id;
    }

    public Imei(){}

    public Imei(String imei, int id) {
        this.imei = imei;
        Id = id;
    }

    public void setId(int id) {
        Id = id;
    }
}
