// https://github.com/ampotty/uip-pc2/Ejemplos/TrabajaVago

package com.trabajavago;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        byte opcion = 0;
        ArrayList<Tarea> lista_tareas = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("\n\nAPP: TRABAJAVAGO");
            System.out.println("1. Agregar\n2. Ver\n3. Completar\n4. Salir");
            System.out.print("Opcion: ");
            try {
                opcion = Byte.parseByte(br.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Dato invalido.");
            } catch (Exception e) {
                System.out.println("Error desconocido.");
            }

            switch (opcion) {
                case 1:
                    String nombre, fecha_tope, criticidad;
                    System.out.print("Nombre: ");
                    nombre = br.readLine();
                    System.out.print("Fecha Tope: ");
                    fecha_tope = br.readLine();
                    do {
                        System.out.print("Criticidad (Alta/Media/Baja): ");
                        criticidad = br.readLine();
                        if (criticidad.toLowerCase().equals("alta") || criticidad.toLowerCase().equals("media")
                                || criticidad.toLowerCase().equals("baja"))
                            break;
                        else
                            System.out.println("¡Criticidad invalida!");
                    } while(true);

                    //Tarea t = new Tarea(nombre, fecha_tope, criticidad);
                    Tarea t = new Tarea();
                    t.setNombre(nombre);
                    t.setEstado("EnProgreso");
                    t.setCriticidad(criticidad);
                    t.setFecha_tope(fecha_tope);
                    lista_tareas.add(t);
                    break;
                case 2:
                    if (lista_tareas.size() == 0) {
                        System.out.println("No hay tareas pendientes.");
                    } else {
                        for (Tarea a : lista_tareas) {
                            System.out.println("[] " + a.getNombre() + " (" + a.getFecha_tope() + ")");
                            System.out.println("Criticidad: " + a.getCriticidad());
                        }
                    }
                    break;
                case 3:
                    
                    break;
                case 4:
                    System.out.println("Hasta el viernes!");
                    break;
                default:
                    System.out.println("Opcion fuera de rango");
                    break;
            }
        } while(opcion != 4);
    }
}
