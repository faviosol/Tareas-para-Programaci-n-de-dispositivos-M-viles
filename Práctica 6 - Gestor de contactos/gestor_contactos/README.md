# Gestor de Contactos con Favoritos

Aplicación Android desarrollada con Kotlin y Jetpack Compose que permite registrar contactos, marcarlos como favoritos, buscarlos y eliminarlos con confirmación, utilizando navegación entre pantallas.

## Autor
**Favio Solórzano Vilca**

## Repositorio
[https://github.com/faviosol/Tareas-para-Programaci-n-de-dispositivos-M-viles](https://github.com/faviosol/Tareas-para-Programaci-n-de-dispositivos-M-viles)

---

## Requisitos

- Android Studio Giraffe o superior
- Kotlin 1.8.10
- Android mínimo: API 26 (Android 8.0)
- Dispositivo físico o emulador con Android 8.0+

---

## Estructura del proyecto

```
app/src/main/java/com/solorzano/gestor_contactos/
├── MainActivity.kt       # Configura la navegación principal
├── Contacto.kt           # Modelo de datos del contacto
├── ListaScreen.kt        # Pantalla de lista con buscador y favoritos
└── FormularioScreen.kt   # Pantalla de registro de nuevo contacto
```

---

## Funcionalidades

### Requeridas
- Lista de contactos con `LazyColumn`
- Marcar y desmarcar contactos como favoritos
- Favoritos se muestran siempre al inicio de la lista
- Eliminar contactos
- Formulario con campos de nombre y teléfono
- Navegación entre pantallas con `NavHost` y `NavController`
- Estado manejado con `remember` (sin ViewModel)

### Adicionales
- Buscador de contactos por nombre en tiempo real
- Diálogo de confirmación antes de eliminar un contacto
- Contador de total de contactos y favoritos
- Validación de campos obligatorios en el formulario
- Mensaje de lista vacía cuando no hay resultados

---

## Cómo ejecutar

1. Clona el repositorio
2. Abre el proyecto en Android Studio Giraffe
3. Conecta tu dispositivo Android por USB con depuración activada
4. Presiona el botón **Run** (triángulo verde) en Android Studio

---

## Tecnologías utilizadas

| Tecnología | Versión |
|---|---|
| Kotlin | 1.8.10 |
| Jetpack Compose BOM | 2023.03.00 |
| Navigation Compose | 2.7.7 |
| Material3 | vía BOM |
| Activity Compose | 1.7.2 |
