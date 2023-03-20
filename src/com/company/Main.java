package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        String rutaPronostico = "./recursos/pronostico.csv";
        String rutaResultados = "./recursos/resultados.csv";
        ArrayList<Partido> partidos = new ArrayList<Partido>();
        Ronda ronda = new Ronda(partidos);
        leerResultados(rutaResultados, ronda);
        leerPronostico(rutaPronostico, ronda);
    }

    // Función para leer los resultados
    private static void leerResultados(String rutaResultados, Ronda ronda) throws IOException {
        Path pathResultados = Paths.get(rutaResultados);
        try {
            for (String line: Files.readAllLines(pathResultados)) {
                String[] datos = line.split(",");
                Equipo equipo1 = new Equipo (datos[0]);
                Equipo equipo2 = new Equipo (datos[3]);
                Partido partido = new Partido(equipo1, equipo2, Integer.parseInt(datos[1]), Integer.parseInt(datos[2]));
                ronda.agregarPartido(partido);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo");
        }
    }

    // Función para leer el pronóstico
    private static void leerPronostico(String rutaPronostico, Ronda ronda) throws IOException {
        try {
            Path pathPronostico = Paths.get(rutaPronostico);
            for (String line: Files.readAllLines(pathPronostico)) {
                int i = 0;
                String[] datos = line.split(",");
                Equipo equipo1 = new Equipo (datos[0]);
                Equipo equipo2 = new Equipo (datos[4]);
                String gana1 = datos[1];
                String empata = datos[2];
                String gana2 = datos[3];

                boolean[] ganador = {false, false, false};

                if (gana1.equals("X")) {
                    ganador[0] = true;
                    Pronostico pronostico = new Pronostico(ronda.getPartidos().get(i), equipo1, ResultadoEnum.Ganador);
                } else if (empata.equals("X")) {
                    ganador[1] = true;
                    Pronostico pronostico = new Pronostico(ronda.getPartidos().get(i), null, ResultadoEnum.Empate);
                } else if (gana2.equals("X")) {
                    ganador[2] = true;
                    Pronostico pronostico = new Pronostico(ronda.getPartidos().get(i), equipo2, ResultadoEnum.Ganador);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo");
        }
    }
}
