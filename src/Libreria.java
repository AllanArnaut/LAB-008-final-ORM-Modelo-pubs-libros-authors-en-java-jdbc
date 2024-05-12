/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
import java.util.Scanner;

public class Libreria {
    private Modelo modelo;
    private PantallaUsuario pantallaUsuario;
    private Reportes reportes;

    public Libreria() {
        modelo = new Modelo();
        pantallaUsuario = new PantallaUsuario();
        reportes = new Reportes(modelo);
    }

    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("----- MENU PRINCIPAL -----");
            System.out.println("1. Realizar venta");
            System.out.println("2. Generar reporte de ventas por tienda");
            System.out.println("3. Generar reporte de ventas por libro");
            System.out.println("4. Salir");
            System.out.print("Ingrese su opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    pantallaUsuario.realizarVenta();
                    break;
                case 2:
                    reportes.generarReporteVentasPorTienda();
                    break;
                case 3:
                    System.out.print("Ingrese el ID del libro: ");
                    String titleId = scanner.next();
                    reportes.generarReporteVentasPorLibro(titleId);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opcion no valida. Por favor, intente nuevamente.");
                    break;
            }
        } while (opcion != 4);

        scanner.close();
    }

    public static void main(String[] args) {
        Libreria libreria = new Libreria();
        libreria.menuPrincipal();
    }
}

