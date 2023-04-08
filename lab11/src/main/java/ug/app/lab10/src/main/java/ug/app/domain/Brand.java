package ug.app.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Brand {
    private Long Id;
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return Id;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", smartphones=" + smartphones +
                '}';
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "brand")
    public Collection<Smartphone> getSmartphones() {
        return smartphones;
    }

    public void setSmartphones(Collection<Smartphone> smartphones) {
        this.smartphones = smartphones;
    }

    public Brand(Long id, String name) {
        Id = id;
        this.name = name;
    }

    public Brand(){}

    private Collection<Smartphone> smartphones;
}
