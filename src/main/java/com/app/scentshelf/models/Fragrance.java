package com.app.scentshelf.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

//@getter, @setter, @noargsconstruct are part of lombok dependency which basically reduces extra code
//https://www.baeldung.com/intro-to-project-lombok
@Entity
@Getter
@Setter
@NoArgsConstructor // <--- THIS is it
@Table(name = "fragrance")
public class Fragrance {

    /**
     * https://www.javaguides.net/2018/12/hibernatejpa-primary-key-generation-stratergies.html
     * The GenerationType.IDENTITY is the easiest to use but not the best one from a performance point of view.
     * It relies on an auto-incremented database column and lets the database generate a new value with each insert operation.
     * From a database point of view, this is very efficient because the auto-increment columns are highly optimized, and it doesn’t require any additional statements.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "fragrance_id")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "image_url")
    private String image_url;

    // Constructor with all fields
    public Fragrance(String name, String brand, String image_url) {
        this.name = name;
        this.brand = brand;
        this.image_url = image_url;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Fragrance)) {
            return false;
        }
        return id != null && id.equals(((Fragrance) o).id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Fragrance{" +
                "id=" + getId() +
                ", name='" + getName() + "'" +
                ", brand='" + getBrand() + "'" +
                ", image_url'" + getImage_url() + "'" +
                "}";
    }
}
