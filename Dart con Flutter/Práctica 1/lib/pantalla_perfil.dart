import 'package:flutter/material.dart';

class PantallaPerfil extends StatelessWidget {
  const PantallaPerfil({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Mi Perfil'),
        backgroundColor: Colors.teal,
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          children: [
            // Puedes cambiar este link por cualquier imagen que quieras de internet
            Image.network(
              'https://picsum.photos/200',//lo que hace es mostrar una imagen random
              height: 150,
            ),
            const SizedBox(height: 20),
            const Text(
              'Favio',
              style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
            ),
            const Text('Estudiante de Desarrollo Móvil'),
            const SizedBox(height: 30),
            const Row(
              children: [
                Icon(Icons.email, color: Colors.teal),
                SizedBox(width: 10),
                Text('faviosol@hotmail.com'),
              ],
            ),
            const Row(
              children: [
                Icon(Icons.phone_iphone, color: Colors.teal),
                SizedBox(width: 10),
                Text('900833087'),
              ],
            )
          ], // Children
        ),
      ),
    );
  }
}