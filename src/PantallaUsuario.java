/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
import java.sql.*;
import java.util.Scanner;

public class PantallaUsuario {
    private Scanner scanner;
    private Modelo modelo;
    private Connection conexion;

    public PantallaUsuario() {
        scanner = new Scanner(System.in);
        modelo = new Modelo();
        conexion = Conexion.conectar();
    }

    public void realizarVenta() {
        try {
            // Solicitar datos de la venta al usuario
            System.out.print("Ingrese el ID de la tienda: ");
            String storId = scanner.nextLine();
            System.out.print("Ingrese el numero de orden: ");
            String ordNum = scanner.nextLine();
            System.out.print("Ingrese la fecha de la orden (YYYY-MM-DD HH:MM:SS): ");
            String ordDateStr = scanner.nextLine();
            Timestamp ordDate = Timestamp.valueOf(ordDateStr);
            System.out.print("Ingrese la cantidad: ");
            int qty = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente
            System.out.print("Ingrese los terminos de pago: ");
            String payterms = scanner.nextLine();
            System.out.print("Ingrese el ID del titulo del libro: ");
            String titleId = scanner.nextLine();

            // Crear la sentencia SQL de inserción
            String sql = "INSERT INTO sales (stor_id, ord_num, ord_date, qty, payterms, title_id) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, storId);
            preparedStatement.setString(2, ordNum);
            preparedStatement.setTimestamp(3, ordDate);
            preparedStatement.setInt(4, qty);
            preparedStatement.setString(5, payterms);
            preparedStatement.setString(6, titleId);

            // Ejecutar la sentencia SQL de inserción
            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Venta realizada con exito.");
            } else {
                System.out.println("Error al realizar la venta.");
            }
        } catch (SQLException e) {
            System.err.println("Error al realizar la venta: " + e.getMessage());
        }
    }
}
