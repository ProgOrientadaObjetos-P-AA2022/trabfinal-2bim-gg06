/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;

/**
 *
 * @author maisc
 * @author frank
 * 
 */

public abstract class PlanCelular {
    protected String nombrePro;
    protected String cedulaPro;
    protected String ciudadPro;
    protected String marcaCelular;//una cadena
    protected String modeloCelular;//una cadena
    protected String numeroCelular;//una cadena
    
    protected double pagoMensual;//se debe operar en cada subclase, se lo optiene
                               //en cada clase...

    public PlanCelular(String n, String ce, String ci, 
            String marca, String modelo, String num) {
        nombrePro = n;
        cedulaPro = ce;
        ciudadPro = ci;
        marcaCelular = marca;
        modeloCelular = modelo;
        numeroCelular = num;
    }

    public void establecerNombrePro(String n) {
        nombrePro = n;
    }
    public void establecerCedulaPro(String ce) {
        cedulaPro = ce;
    }
    public void establecerCiudadPro(String ci) {
        ciudadPro = ci;
    }
    public void establecerMarcaCelular(String mar) {
        marcaCelular = mar;
    }
    public void establecerModeloCelular(String mo) {
        modeloCelular = mo;
    }
    public void establecerNumeroCelular(String nu) {
        numeroCelular = nu;
    }
    
    
    public abstract void pagoMensual();  
                                         /// se debe operar en cada subclase, 
                                         /// se lo optiene en cada clase...
    public double obtenerPagoMensual(){
        return pagoMensual;
    }
    public String obtenerNombrePro() {
        return nombrePro;
    }
    public String obtenerCedulaPro() {
        return cedulaPro;
    }
    public String obtenerCiudadPro() {
        return ciudadPro;
    }
    public String obtenerMarcaCelular() {
        return marcaCelular;
    }
    public String obtenerModeloCelular() {
        return modeloCelular;
    }
    public String obtenerNumeroCelular() {
        return numeroCelular;
    }
    
    @Override
    public String toString() {
        String c = String.format("Datos del Propietario\n"
                + "\tNombres: %s\n"
                + "\tCedula: %s\n"
                + "\tCiudad: %s\n"
                + "Datos del Celular\n"
                + "\tMarca: %s\n"
                + "\tModelo: %s\n"
                + "\tNúmero: %s\n",
                obtenerNombrePro(),
                obtenerCedulaPro(),
                obtenerCiudadPro(), 
                obtenerMarcaCelular(),
                obtenerModeloCelular(),
                obtenerNumeroCelular());

        return c;
    }
    
}
