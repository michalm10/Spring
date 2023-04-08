package ug.app.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Users {
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

    public Users(){}

    public Users(String name, int id, Collection<Smartphone> smartphones) {
        this.name = name;
        this.id = id;
        this.smartphones = smartphones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany
    public Collection<Smartphone> getSmartphones() {
        return smartphones;
    }

    public void setSmartphones(Collection<Smartphone> smartphones) {
        this.smartphones = smartphones;
    }

    private Collection<Smartphone> smartphones;
}
