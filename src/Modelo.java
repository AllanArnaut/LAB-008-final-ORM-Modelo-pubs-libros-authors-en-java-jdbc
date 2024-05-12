/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DELL
 */
import java.util.ArrayList;
import java.util.HashMap;

public class Modelo {
    private ArrayList<Title> titles;
    private ArrayList<Sales> sales;
    private ArrayList<Authors> authors;
    // Añade más ArrayLists para las demás clases de entidad si es necesario
    
    // HashMaps adicionales si es necesario
    private HashMap<String, Title> titlesMap;
    private HashMap<String, Sales> salesMap;
    private HashMap<String, Authors> authorsMap;
    // Añade más HashMaps para las demás clases de entidad si es necesario
    
    // Constructor
    public Modelo() {
        // Inicializa las ArrayLists
        titles = new ArrayList<>();
        sales = new ArrayList<>();
        authors = new ArrayList<>();
        // Inicializa los HashMaps si es necesario
        titlesMap = new HashMap<>();
        salesMap = new HashMap<>();
        authorsMap = new HashMap<>();
    }

    // Métodos para gestionar el CRUD de cada objeto
    public void agregarTitle(Title title) {
        titles.add(title);
        titlesMap.put(title.getTitleId(), title);
    }

    public void eliminarTitle(Title title) {
        titles.remove(title);
        titlesMap.remove(title.getTitleId());
    }

    public Title buscarTitlePorId(String titleId) {
        return titlesMap.get(titleId);
    }

    // Repite el mismo patrón para las demás clases de entidad (Sales, Authors, etc.)
}

