import 'package:flutter/material.dart';
//Acá se dejan los imports de las 3 pantallas para poder usarlas por el MaterialApp solo cambiando el comentario más abajo
import 'pantalla_inicio.dart';
import 'pantalla_perfil.dart';
import 'pantalla_hobbies.dart';

//Función que permite ejecutar la app para inflar el widget raíz MyApp
void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(//nos sirve para configurar el diseño visual con MaterialApp
      title: 'Mi App Personal',
      debugShowCheckedModeBanner: false, //con esa linea ocultamos la cinta de debug roja q aparecía

      // Deja sin las barras (//) SOLO la que quieres probar en la web.

      // home: PantallaInicio(),
      //home: PantallaHobbies(),
      home: PantallaPerfil(),
    );
  }
}