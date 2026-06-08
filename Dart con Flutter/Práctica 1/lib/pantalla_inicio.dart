import 'package:flutter/material.dart';
//heredamos de StatelessWidget porque manejamos por ahora interfaces státicas
class PantallaInicio extends StatelessWidget {
  const PantallaInicio({super.key});

  @override
  Widget build(BuildContext context) {
    //retornamos el scaffold para poder dimensionar las interfaces en celular o web
    return Scaffold(
      appBar: AppBar(//widget para poder visualizar una representación de cada zona en cada interfaz
        title: const Text('Bienvenido'),
        backgroundColor: Colors.blue,
      ),
      body: Center(//define la parte central del scafflold con los demás widgets que acompañan
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            const Text(
              '¡Hola! Bienvenido a mi aplicación personal.',
              style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {}, // Vacío porque la guía no pide lógica todavía
              child: const Text('Ver mi perfil'),
            ),
          ],
        ),
      ),
    );
  }
}