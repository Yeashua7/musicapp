// Archivo: src/main/java/com/example/musicapp/model/Cancion.java
package com.example.musicapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "canciones")
@Getter
@Setter
@NoArgsConstructor
public class Cancion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private int anoLanzamiento;

    @ManyToOne
    @JoinColumn(name = "cantante_id", nullable = false)
    private Cantante cantante;

    @Override
    public String toString() {
        return "'" + titulo + "' (" + anoLanzamiento + ")";
    }
}