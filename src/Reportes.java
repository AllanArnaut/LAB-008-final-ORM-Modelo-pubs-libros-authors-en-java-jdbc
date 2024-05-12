/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
import java.sql.*;

public class Reportes {
    private Modelo modelo;
    private Connection conexion;

    public Reportes(Modelo modelo) {
        this.modelo = modelo;
        conexion = Conexion.conectar();
    }
    public void generarReporteVentasPorTienda() {
        try {
            // Crear la sentencia SQL de consulta
            String sql = "SELECT * FROM sales";
            Statement statement = conexion.createStatement();

            // Ejecutar la consulta SQL
            ResultSet resultSet = statement.executeQuery(sql);

            // Mostrar los resultados de la consulta
            System.out.println("Reporte de ventas por tienda:");
            System.out.println("------------------------------");
            while (resultSet.next()) {
                String storId = resultSet.getString("stor_id");
                String ordNum = resultSet.getString("ord_num");
                Date ordDate = resultSet.getDate("ord_date");
                int qty = resultSet.getInt("qty");
                String payterms = resultSet.getString("payterms");
                String titleId = resultSet.getString("title_id");

                System.out.println("ID de la tienda: " + storId);
                System.out.println("Numero de orden: " + ordNum);
                System.out.println("Fecha de orden: " + ordDate);
                System.out.println("Cantidad: " + qty);
                System.out.println("Terminos de pago: " + payterms);
                System.out.println("ID del titulo del libro: " + titleId);
                System.out.println("------------------------------");
            }

            // Cerrar recursos
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Error al generar el reporte de ventas por tienda: " + e.getMessage());
        }
    }
    public void generarReporteVentasPorLibro(String titleId) {
        try {
            // Crear la sentencia SQL de consulta
            String sql = "SELECT * FROM sales WHERE title_id = ?";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, titleId);

            // Ejecutar la consulta SQL
            ResultSet resultSet = preparedStatement.executeQuery();

            // Mostrar los resultados de la consulta
            System.out.println("Reporte de ventas para el libro con ID " + titleId + ":");
            System.out.println("------------------------------------");
            while (resultSet.next()) {
                String storId = resultSet.getString("stor_id");
                String ordNum = resultSet.getString("ord_num");
                Date ordDate = resultSet.getDate("ord_date");
                int qty = resultSet.getInt("qty");
                String payterms = resultSet.getString("payterms");

                System.out.println("ID de la tienda: " + storId);
                System.out.println("Numero de orden: " + ordNum);
                System.out.println("Fecha de orden: " + ordDate);
                System.out.println("Cantidad: " + qty);
                System.out.println("Terminos de pago: " + payterms);
                System.out.println("------------------------------------");
            }

            // Cerrar recursos
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            System.err.println("Error al generar el reporte de ventas por libro: " + e.getMessage());
        }
    }
}

