import 'package:flutter/material.dart';

class PantallaHobbies extends StatelessWidget {
  const PantallaHobbies({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Mis Hobbies'),
        backgroundColor: Colors.orange,
      ),
      body: const Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text('Mis 3 actividades favoritas:', style: TextStyle(fontSize: 18)),
            SizedBox(height: 20),
            Row(
              children: [
                Icon(Icons.gamepad, color: Colors.orange),
                SizedBox(width: 10),
                Text('Jugar Videojuegos'),
              ],
            ),
            SizedBox(height: 15),
            Row(
              children: [
                Icon(Icons.music_note, color: Colors.orange),
                SizedBox(width: 10),
                Text('Escuchar Música'),
              ],
            ),
            //sizedbox es para separar verticalmente al antojo en el 2do parámetro como ejemplo pusimos 15
            SizedBox(height: 15),
            Row(
              children: [
                Icon(Icons.sports_soccer, color: Colors.orange),
                SizedBox(width: 10),
                Text('Hacer Deporte'),
              ],
            ),
          ],
        ),
      ),
    );
  }
}