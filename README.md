# Mi Aplicación — organizador personal de salud

Aplicación Android desarrollada en Java para organizar información cotidiana de salud desde el teléfono. Reúne perfiles personales, contactos médicos, medicamentos, citas y actividad física, y ofrece una vista semanal que combina elementos del día. Es un proyecto académico de gestión y seguimiento personal; no sustituye la orientación de profesionales de la salud.

## Funcionalidades

- Crear y seleccionar perfiles con nombre, relación y correo electrónico.
- Registrar médicos con especialidad y datos de contacto.
- Añadir medicamentos indicando cantidad, presentación, dosis y hora; consultar la lista del día y elegir acciones de registrar, reprogramar o saltar una toma.
- Agendar citas con título, médico, fecha y hora, y consultar las citas guardadas.
- Registrar actividad física por fecha, tipo, duración y momento del día.
- Consultar una semana en el calendario y ver elementos asociados al día seleccionado.

## Tecnologías

- Java y Android SDK.
- Android Gradle Plugin 8.5.2, Gradle Wrapper 8.7 y scripts de configuración Kotlin DSL.
- AndroidX AppCompat y Activity, Material Components, ConstraintLayout y RecyclerView.
- FloatingActionButton de `com.getbase:floatingactionbutton`.
- JUnit 4, AndroidX Test y Espresso como dependencias de prueba.

## Requisitos

- Android Studio con JDK 17 para ejecutar Gradle y Android Gradle Plugin.
- Android SDK Platform 34 (configurado como `compileSdk` y `targetSdk`).
- Emulador o dispositivo Android 9 (API 28) o posterior para ejecutar la aplicación.
- Git para clonar el repositorio.

El código fuente Java está configurado con compatibilidad de lenguaje 11. El proyecto no requiere servicios externos, claves ni variables de entorno.

## Instalación y ejecución

Clona el repositorio:

```bash
git clone https://github.com/Camilo1138/ProyectoFinal.git
cd ProyectoFinal
```

Abre la carpeta en Android Studio, espera la sincronización de Gradle y ejecuta la configuración `app` en un emulador o dispositivo conectado.

También puedes compilar desde la terminal. En Windows:

```powershell
.\gradlew.bat assembleDebug
```

En macOS o Linux:

```bash
./gradlew assembleDebug
```

## Pruebas

El proyecto incluye un ejemplo de prueba unitaria (`ExampleUnitTest`) y una prueba instrumentada de contexto de aplicación (`ExampleInstrumentedTest`). Son pruebas de ejemplo y no cubren todavía los flujos principales de la aplicación.

```bash
# Pruebas unitarias
./gradlew test

# Pruebas instrumentadas; requiere un emulador o dispositivo conectado
./gradlew connectedAndroidTest
```

En Windows, reemplaza `./gradlew` por `.\gradlew.bat`.

## Arquitectura y persistencia

La aplicación está organizada como un único módulo Android (`app`) y sigue una estructura sencilla basada en pantallas:

- `app/src/main/java/com/example/myapplication/`: actividades de navegación y formularios, modelos de datos, adaptadores de listas y utilidades del calendario.
- `app/src/main/res/layout/`: diseños XML de pantallas y elementos de lista; `values/`, `drawable/`, `font/` y `xml/` contienen recursos, temas y reglas de respaldo.
- `app/src/main/AndroidManifest.xml`: registro de actividades y punto de entrada de la aplicación.
- `app/src/test/` y `app/src/androidTest/`: pruebas locales e instrumentadas.
- `gradle/libs.versions.toml`: versiones y alias de dependencias; `gradle/wrapper/`: versión de Gradle utilizada por el wrapper.

Los datos se guardan localmente en el almacenamiento privado de la aplicación mediante archivos y `SharedPreferences`. Perfiles y médicos se serializan; medicamentos, citas y actividades se escriben en archivos de texto. No hay backend ni sincronización en la nube configurados. Los eventos creados directamente en el calendario se mantienen en memoria y no persisten al cerrar el proceso.

## Capturas

El repositorio no incluye capturas de pantalla de la aplicación, por lo que no se agregan imágenes no verificadas.

## Posibles mejoras

- Añadir pruebas que cubran creación, edición, validación y consulta de perfiles, medicamentos, citas y actividades.
- Centralizar la persistencia en una base de datos local (por ejemplo, Room), con modelos y consultas consistentes.
- Completar la persistencia de eventos del calendario y ofrecer notificaciones para citas o tomas, si se desea ese comportamiento.
- Revisar validaciones y manejo de errores de fechas y formularios.
- Sustituir el identificador de ejemplo `com.example.myapplication` y el nombre genérico de la aplicación antes de distribuirla.
