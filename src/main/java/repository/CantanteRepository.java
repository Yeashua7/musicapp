// Archivo: src/main/java/com/example/musicapp/repository/CantanteRepository.java
package com.example.musicapp.repository;

import com.example.musicapp.model.Cantante;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CantanteRepository extends JpaRepository<Cantante, Long> {
    Optional<Cantante> findByNombreContainingIgnoreCase(String nombre);
}