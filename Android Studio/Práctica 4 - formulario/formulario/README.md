# Práctica 4 - Formulario

Aplicación Android desarrollada en Kotlin como parte del curso de Programación de Dispositivos Móviles. Implementa un formulario de registro con validación de campos, paso de datos entre Activities y pantalla de resumen de confirmación.

## Descripción
La app guía al usuario a través de dos pantallas:
1. **Formulario:** el usuario ingresa sus datos personales.
2. **Resumen:** se muestran los datos para confirmar o volver a editar.

## Funcionalidades
- **Captura de datos:** nombre, edad, ciudad y correo electrónico.
- **Validación de campos:** muestra un Toast si algún campo está vacío.
- **Paso de datos:** entre Activities mediante `Intent` y objeto `Serializable`.
- **Manejo de resultados:** uso de `RESULT_OK` y `RESULT_CANCELED`.
- **Limpieza automática:** el formulario se resetea al confirmar los datos.
- **Preservación de estado:** manejo de rotación de pantalla con `onSaveInstanceState`.

## Tecnologías utilizadas
- **Lenguaje:** Kotlin
- **Plataforma:** Android (API Target 31)
- **IDE:** Android Studio
- **Build:** Gradle (Kotlin DSL)

## Cómo ejecutar
1. Clona el repositorio.
2. Abre la carpeta `Práctica 4 - formulario/formulario` en Android Studio.
3. Conecta un dispositivo o inicia un emulador.
4. Ejecutar la aplicación con **Run > Run 'app'**.
