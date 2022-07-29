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

public class PlanPostPagoMinutosMegas extends PlanCelular{
    
    private double minutos;
    private double costoMinuto;
    private double megasGigas;
    private double costoGigas;

    public PlanPostPagoMinutosMegas(String nombrePro, String cedulaPro, 
            String ciudadPro, String marcaCelular, String modeloCelular, 
            String numeroCelular, double m, double cm, double mg, double cg) {
        super(nombrePro, cedulaPro, ciudadPro, marcaCelular, modeloCelular, 
                numeroCelular);
        minutos = m;
        costoMinuto = cm;
        megasGigas = mg;
        costoGigas = cg;
    }
    
    public void establecerMinutos(double m) {
        minutos = m;
    }
    public void establecerCostoMinuto(double cm) {
        costoMinuto = cm;
    }
    public void establecerMegasGigas(double mg) {
        megasGigas = mg;
    }
    public void establecerCostoGigas(double cg) {
        costoGigas = cg;
    }

    public double obtenerMinutos() {
        return minutos;
    }
    public double obtenerCostoMinuto() {
        return costoMinuto;
    }
    public double obtenerMegasGigas() {
        return megasGigas;
    }
    public double obtenerCostoGigas() {
        return costoGigas;
    }
    
    
    @Override
    public void pagoMensual(){
        pagoMensual = (minutos * costoMinuto) + (megasGigas * costoGigas);
    }                               
 
    @Override
    public String toString() {
        String c = String.format("\n-------Plan PostPago MinutosMegas-------\n"
                + super.toString() + "\nFactura\n"
                + "\tMinutos: %.2f\n"
                + "\tCosto minuto : %.2f\n"
                + "\tNumero de Megas (GB): %.2f\n"
                + "\tCosto del GB: %.2f\n"
                + "\tPago mensual: %.2f\n",
                obtenerMinutos(),
                obtenerCostoMinuto(),
                obtenerMegasGigas(),
                obtenerCostoGigas(),
                obtenerPagoMensual()
        );
        return c;
    }
}
