package com.example.musicapp;

import com.example.musicapp.model.Cancion;
import com.example.musicapp.model.Cantante;
import com.example.musicapp.repository.CancionRepository;
import com.example.musicapp.repository.CantanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class MusicappApplication implements CommandLineRunner {

    // CORRECTO: Pedimos las herramientas (Repositorios) que necesitamos.
    // Spring sí sabe cómo crear y darnos estas.
    @Autowired
    private CantanteRepository cantanteRepository;
    @Autowired
    private CancionRepository cancionRepository;

    public static void main(String[] args) {
        SpringApplication.run(MusicappApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner teclado = new Scanner(System.in);
        var opcion = -1;

        while (opcion != 0) {
            var menu = """
                    \n*** Aplicación de Música ***
                    1 - Registrar Cantante
                    2 - Registrar Canción
                    3 - Buscar Canciones por Cantante
                    
                    0 - Salir
                    Elija una opción:
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    registrarCantante(teclado);
                    break;
                case 2:
                    registrarCancion(teclado);
                    break;
                case 3:
                    buscarCancionesPorCantante(teclado);
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private void registrarCantante(Scanner teclado) {
        System.out.print("Introduce el nombre del cantante: ");
        var nombre = teclado.nextLine();
        System.out.print("Introduce la nacionalidad del cantante: ");
        var nacionalidad = teclado.nextLine();

        // CORRECTO: Creamos el objeto "dato" (la entidad) aquí, cuando tenemos la información.
        Cantante cantante = new Cantante();
        cantante.setNombre(nombre);
        cantante.setNacionalidad(nacionalidad);

        cantanteRepository.save(cantante); // Usamos la "herramienta" para guardar el "dato".
        System.out.println("¡Cantante registrado con éxito!");
    }

    private void registrarCancion(Scanner teclado) {
        System.out.print("Introduce el nombre del cantante para asociar la canción: ");
        var nombreCantante = teclado.nextLine();

        Optional<Cantante> cantanteOptional = cantanteRepository.findByNombreContainingIgnoreCase(nombreCantante);

        if (cantanteOptional.isPresent()) {
            Cantante cantante = cantanteOptional.get();
            System.out.print("Introduce el título de la canción: ");
            var tituloCancion = teclado.nextLine();
            System.out.print("Introduce el año de lanzamiento: ");
            var anoLanzamiento = teclado.nextInt();
            teclado.nextLine();

            Cancion cancion = new Cancion(); // Creamos el "dato" de la canción
            cancion.setTitulo(tituloCancion);
            cancion.setAnoLanzamiento(anoLanzamiento);
            cancion.setCantante(cantante);

            cancionRepository.save(cancion);
            System.out.println("¡Canción registrada con éxito para " + cantante.getNombre() + "!");
        } else {
            System.out.println("Error: Cantante no encontrado. Registra primero al cantante.");
        }
    }

    private void buscarCancionesPorCantante(Scanner teclado) {
        System.out.print("Introduce el nombre del cantante para ver sus canciones: ");
        var nombreCantante = teclado.nextLine();

        List<Cancion> canciones = cancionRepository.findByCantanteNombreContainingIgnoreCase(nombreCantante);

        if (!canciones.isEmpty()) {
            System.out.println("\nCanciones de " + canciones.get(0).getCantante().getNombre() + ":");
            canciones.forEach(System.out::println);
        } else {
            System.out.println("No se encontraron canciones para ese cantante.");
        }
    }
}