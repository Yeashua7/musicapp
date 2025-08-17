// Archivo: src/main/java/com/example/musicapp/repository/CancionRepository.java
package com.example.musicapp.repository;

import com.example.musicapp.model.Cancion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CancionRepository extends JpaRepository<Cancion, Long> {
    List<Cancion> findByCantanteNombreContainingIgnoreCase(String nombre);
}