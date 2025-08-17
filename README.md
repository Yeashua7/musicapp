Aplicación de Catálogo Musical (MusicApp)
Esta es una aplicación de consola (CLI) desarrollada en Java con el framework Spring Boot. Su propósito es permitir a los usuarios gestionar un catálogo simple de cantantes y sus canciones, interactuando a través de un menú en la terminal.
Este proyecto fue creado como una herramienta de aprendizaje para afianzar conceptos clave del ecosistema Spring, como Spring Data JPA, la inyección de dependencias y la configuración de una aplicación conectada a una base de datos.
Características Principales
Registro de Cantantes: Permite añadir nuevos cantantes a la base de datos, almacenando su nombre y nacionalidad.
Registro de Canciones: Permite registrar nuevas canciones, especificando su título, año de lanzamiento y asociándolas a un cantante existente.
Búsqueda de Canciones: Permite listar todas las canciones registradas de un cantante específico.
Interfaz Interactiva: Toda la interacción se realiza a través de un menú de opciones simple y claro en la consola.
Base de Datos en Memoria: Utiliza H2 Database, que se ejecuta en memoria, por lo que no requiere ninguna instalación ni configuración de un gestor de base de datos externo. Los datos se reinician cada vez que se detiene la aplicación.
Tecnologías Utilizadas
Lenguaje: Java 17
Framework: Spring Boot 3
Acceso a Datos: Spring Data JPA (con Hibernate como proveedor)
Gestor de Dependencias: Maven
Base de Datos: H2 Database (en memoria)
Utilidades: Lombok (para reducir código boilerplate)
Prerrequisitos
Antes de empezar, asegúrate de tener instalado en tu sistema:
JDK (Java Development Kit) - Versión 17 o superior.
Apache Maven - Versión 3.8 o superior.
Un IDE de tu preferencia, como IntelliJ IDEA Community Edition.
Instalación y Puesta en Marcha
Sigue estos pasos para ejecutar el proyecto en tu máquina local:
Clona el repositorio (o simplemente copia los archivos en una carpeta local):
code
Bash
git clone https://URL_DE_TU_REPOSITORIO.git
cd musicapp
Abre el proyecto en tu IDE.
En IntelliJ IDEA, ve a File > Open... y selecciona la carpeta raíz del proyecto (la que contiene el archivo pom.xml).
Espera a que Maven descargue las dependencias.
El IDE detectará el archivo pom.xml y descargará automáticamente todas las librerías necesarias. Puedes ver el progreso en la esquina inferior derecha.
¡Importante! Configuración de Lombok en IntelliJ IDEA.
Instala el Plugin: Ve a File > Settings > Plugins, busca "Lombok" en el Marketplace e instálalo. Reinicia el IDE.
Habilita el Procesamiento de Anotaciones: Ve a File > Settings > Build, Execution, Deployment > Compiler > Annotation Processors y marca la casilla Enable annotation processing.
Cómo Usar la Aplicación
Localiza el archivo MusicappApplication.java en el paquete src/main/java/com/example/musicapp.
Haz clic en el icono de "play" ▶️ verde que aparece al lado del método main y selecciona Run 'MusicappApplication.main()'.
La aplicación se compilará y se iniciará. En la ventana de la consola (Run), verás el siguiente menú:
code
Code
*** Aplicación de Música ***
1 - Registrar Cantante
2 - Registrar Canción
3 - Buscar Canciones por Cantante

0 - Salir
Elija una opción:
Interactúa con la aplicación escribiendo el número de la opción deseada y presionando Enter. Sigue las instrucciones que aparecen en pantalla.
Estructura del Proyecto
code
Code
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── musicapp
│   │   │               ├── model         # Clases @Entity (Cantante, Cancion)
│   │   │               ├── repository    # Interfaces JpaRepository (CantanteRepository, CancionRepository)
│   │   │               └── MusicappApplication.java # Clase principal y lógica de la consola
│   │   └── resources
│   │       └── application.properties   # Configuración de la aplicación (base de datos, etc.)
│   └── test
└── pom.xml             # Archivo de configuración de Maven y dependencias
Futuras Mejoras (Opcional)
Integrar la API de OpenAI (ChatGPT) para obtener biografías de los cantantes.
Añadir más entidades, como Album, y establecer sus relaciones.
Implementar más opciones de búsqueda (por año, por título de canción, etc.).
Migrar de una aplicación de consola a una API REST con endpoints para cada funcionalidad.