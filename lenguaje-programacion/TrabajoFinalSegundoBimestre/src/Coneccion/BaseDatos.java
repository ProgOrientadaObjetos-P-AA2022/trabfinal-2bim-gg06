/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coneccion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import paquete01.*;
/**
 *
 * @author maisc
 */
public class BaseDatos {

    private Connection conn;
       
    
    //Se coneccta a la base de datos...
    public void establecerConexion() {  
        try {
            String url = "jdbc:sqlite:bd/planes.db.db";
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
    } 
    public Connection obtenerConexion(){
        return conn;
    }

    
    //Se insertan datos
    public void insertarPlanCelularPosPagoMegas(PlanPostPagoMegas plan) {  
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO planPostPagoMegas"
                    + " (nombrePro,cedulaPro,ciudadPro,marcaCelular,"
                    + "modeloCelular,numeroCelular, megasGg, costoGiga, "
                    + "tarifaBase) "
                    + "values ('%s','%s','%s','%s','%s','%s', %s, %s, "
                    + "%s)", 
                    plan.obtenerNombrePro(),
                    plan.obtenerCedulaPro(),
                    plan.obtenerNumeroCelular(),
                    plan.obtenerMarcaCelular(),
                    plan.obtenerModeloCelular(),
                    plan.obtenerNumeroCelular(),
                    plan.obtenerMegasGg(),
                    plan.obtenerCostoGiga(),
                    plan.obtenerTarifaBase()
            );
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception:");
             System.out.println(e.getMessage());  
        }  
    }
    //Se leen datos.
    public ArrayList<PlanPostPagoMegas> obtenerDataPlanPostPagoMegas() {  
        ArrayList<PlanPostPagoMegas> lista1 = new ArrayList<>();
        try{  
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from planPostPagoMegas;";
            ResultSet rs = statement.executeQuery(data);
            while(rs.next()){
                PlanPostPagoMegas planM = new PlanPostPagoMegas(
                        rs.getString("nombrePro"),
                        rs.getString("cedulaPro"),
                        rs.getString("ciudadPro"),
                        rs.getString("marcaCelular"),
                        rs.getString("modeloCelular"),
                        rs.getString("numeroCelular"),
                        rs.getDouble("megasGg"),
                        rs.getDouble("costoGiga"),
                        rs.getDouble("tarifaBase")
                );
                planM.pagoMensual();
                
                lista1.add(planM);
            }
            obtenerConexion().close();
        } catch (SQLException e) {  
             System.out.println("Exception: insertarPostPagoMinutosMegas");
             System.out.println(e.getMessage());  
        }  
        return lista1;
    }
    
    
    
    
    
    //Se insertan datos
    public void insertarPostPagoMinutos(PlanPostPagoMinutos plan) {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data1 = String.format("INSERT INTO planPostPagoMinutos"
                    + " (nombrePro, cedulaPro, ciudadPro, marcaCelular,"
                    + "modeloCelular ,numeroCelular ,minutosNacionales,"
                    + " costoMinutoNa, minutosInternacional, costoMinutoIn) "
                    + "values ('%s', '%s', '%s', '%s', '%s','%s', "
                    + "%s, %s,%s, %s)",
                    plan.obtenerNombrePro(),
                    plan.obtenerCedulaPro(),
                    plan.obtenerCiudadPro(),
                    plan.obtenerMarcaCelular(),
                    plan.obtenerModeloCelular(),
                    plan.obtenerNumeroCelular(),
                    plan.obtenerMinutosNacionales(),
                    plan.obtenerCostoMinutosNa(),
                    plan.obtenerMinutosInternacional(),
                    plan.obtenerCostoMinutosIn()
            );
            System.out.println("\n");
            statement.executeUpdate(data1);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPagoMinutos");
            System.out.println(e.getMessage());

        }
    }
    //Se leen datos.
    public ArrayList<PlanPostPagoMinutos> obtenerDataPostPagoMinutos() {
        ArrayList<PlanPostPagoMinutos> lista2 = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMinutos;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMinutos plan = new PlanPostPagoMinutos(
                        rs.getString("nombrePro"),
                        rs.getString("cedulaPro"),
                        rs.getString("ciudadPro"),
                        rs.getString("marcaCelular"),
                        rs.getString("modeloCelular"),
                        rs.getString("numeroCelular"),
                        rs.getDouble("minutosNacionales"),
                        rs.getDouble("costoMinutoNa"),
                        rs.getDouble("minutosInternacional"),
                        rs.getDouble("costoMinutoIn"));
                plan.pagoMensual();
                lista2.add(plan);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPostPagoMinutos");
            System.out.println(e.getMessage());

        }
        return lista2;
    }

    
    
    
    
    //Se insertan datos
    public void insertarPostPagoMinutosMegas(PlanPostPagoMinutosMegas plan) {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO PlanPostPagoMinutosMegas"
                    + " (nombrePro, cedulaPro, ciudadPro, marcaCelular,"
                    + " modeloCelular, numeroCelular, minutos, costoMinuto, "
                    + "megasGigas, costoGigas) "
                    + "values ('%s', '%s', '%s', '%s', '%s', "
                    + "'%s', %s, %s, %s, %s)",
                    plan.obtenerNombrePro(),
                    plan.obtenerCedulaPro(),
                    plan.obtenerCiudadPro(),
                    plan.obtenerMarcaCelular(),
                    plan.obtenerModeloCelular(),
                    plan.obtenerNumeroCelular(),
                    plan.obtenerMinutos(),
                    plan.obtenerCostoMinuto(),
                    plan.obtenerMegasGigas(),
                    plan.obtenerCostoGigas()
                    );
            System.out.println("\n");
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPostPagoMinutosMegas");
            System.out.println(e.getMessage());

        }
    }
    //Se leen datos.
    public ArrayList<PlanPostPagoMinutosMegas> obtenerDataPostPagoMinutosMegas() {
        ArrayList<PlanPostPagoMinutosMegas> lista3 = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMinutosMegas;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMinutosMegas plan = new PlanPostPagoMinutosMegas(
                        rs.getString("nombrePro"),
                        rs.getString("cedulaPro"),
                        rs.getString("ciudadPro"),
                        rs.getString("marcaCelular"),
                        rs.getString("modeloCelular"),
                        rs.getString("numeroCelular"),
                        rs.getDouble("minutos"),
                        rs.getDouble("costoMinuto"),
                        rs.getDouble("megasGigas"),
                        rs.getDouble("costoGigas"));
                plan.pagoMensual();
                lista3.add(plan);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPostPagoMinutosMegas");
            System.out.println(e.getMessage());

        }
        return lista3;

    }
    
    
    
    //Se insertan datos
    public void insertarPostPagoMinutosMegasEc
        (PlanPostPagoMinutosMegasEconomico plan) {
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO PlanPostPagoMinutosMegasEconomico"
                    + " (nombrePro,cedulaPro,ciudadPro,marcaCelular,"
                    + "modeloCelular,numeroCelular, minutos, costoMinuto, "
                    + "megasGigas, costoGigas, descuento) "
                    + "values ('%s', '%s', '%s', '%s', '%s','%s', "
                    + "%s, %s,%s, %s, %s)",
                    plan.obtenerNombrePro(),
                    plan.obtenerCedulaPro(),
                    plan.obtenerCiudadPro(),
                    plan.obtenerMarcaCelular(),
                    plan.obtenerModeloCelular(),
                    plan.obtenerNumeroCelular(),
                    plan.obtenerMinutos(),
                    plan.obtenerCostoMinuto(),
                     plan.obtenerMinutos(),
                    plan.obtenerCostoMinuto(),
                    plan.obtenerMegasGigas(),
                    plan.obtenerCostoGigas()
            );
            System.out.println("\n");
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPostPagoMinutosMegasEc");
            System.out.println(e.getMessage());

        }
    }
    //Se leen datos.
    public ArrayList<PlanPostPagoMinutosMegasEconomico> 
        obtenerDataPostPagoMinutosMegasEc() {
        ArrayList<PlanPostPagoMinutosMegasEconomico> lista4 = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from PlanPostPagoMinutosMegasEconomico;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                PlanPostPagoMinutosMegasEconomico plan = 
                        new PlanPostPagoMinutosMegasEconomico(
                        rs.getString("nombrePro"),
                        rs.getString("cedulaPro"),
                        rs.getString("ciudadPro"),
                        rs.getString("marcaCelular"),
                        rs.getString("modeloCelular"),
                        rs.getString("numeroCelular"),
                        rs.getDouble("minutos"),
                        rs.getDouble("costoMinuto"),
                        rs.getDouble("megasGigas"),
                        rs.getDouble("costoGigas"),
                        rs.getDouble("descuento")        
                );
                plan.pagoMensual();
                lista4.add(plan);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarPlanPostPagoMinutosMegasEconomico");
            System.out.println(e.getMessage());

        }
        return lista4;
    }
    
    
    
}

