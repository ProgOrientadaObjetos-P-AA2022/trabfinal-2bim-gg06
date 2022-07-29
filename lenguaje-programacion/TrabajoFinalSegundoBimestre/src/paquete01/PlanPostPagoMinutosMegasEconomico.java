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

public class PlanPostPagoMinutosMegasEconomico extends PlanCelular{
    
    private double minutos;
    private double costoMinuto;
    private double megasGigas;
    private double costoGigas;
    private double descuento;

    public PlanPostPagoMinutosMegasEconomico(String nombrePro, String cedulaPro,
            String ciudadPro, String marcaCelular, String modeloCelular, 
            String numeroCelular, double m, double cm, double mg, double cg, 
            double d) {
        super(nombrePro, cedulaPro, ciudadPro, marcaCelular, modeloCelular, 
                numeroCelular);
        minutos = m;
        costoMinuto = cm;
        megasGigas = mg;
        costoGigas = cg;
        descuento = d;
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
    public void establecerDescuento(double d) {
        descuento = d;
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
    public double obtenerDescuento(){
        return descuento;
    }
    
    @Override
    public void pagoMensual(){
        double operacion = (minutos * costoMinuto) + (megasGigas * costoGigas);
        pagoMensual =  (descuento * operacion) - operacion ;
    }                               

    @Override
    public String toString() {
         String c = String.format("\n-------Plan PostPago MinutosMegas Economico"
                 + "-------\n"
                + super.toString() + "\nFactura\n"
                + "\tMinutos: %.2f\n"
                + "\tCosto minuto : %.2f\n"
                + "\tNumero de Megas en Gg: %.2f\n"
                + "\tCosto del GB: %.2f\n"
                + "\tPorcentage Descuento: %.2f\n"
                + "\tPago mensual: %.2f\n",
                obtenerMinutos(),
                obtenerCostoMinuto(),
                obtenerMegasGigas(),
                obtenerCostoGigas(),
                obtenerDescuento(),
                obtenerPagoMensual());
        return c;
    }
}
