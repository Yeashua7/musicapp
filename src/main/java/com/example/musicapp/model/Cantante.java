// Archivo: src/main/java/com/example/musicapp/model/Cantante.java
package com.example.musicapp.model;

import jakarta.persistence.*;
        import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cantantes")
@Getter
@Setter
@NoArgsConstructor
public class Cantante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombre;

    private String nacionalidad;

    @OneToMany(mappedBy = "cantante", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Cancion> canciones = new ArrayList<>();

    @Override
    public String toString() {
        return "Cantante [id=" + id + ", nombre='" + nombre + "', nacionalidad='" + nacionalidad + "']";
    }
}
