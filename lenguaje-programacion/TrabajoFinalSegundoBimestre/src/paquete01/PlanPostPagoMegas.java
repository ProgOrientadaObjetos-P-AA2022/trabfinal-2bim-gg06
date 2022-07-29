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

public class PlanPostPagoMegas extends PlanCelular{
    
    private double megasGg;
    private double costoGiga;
    private double tarifaBase;

    //heredado de PlanCelular
    public PlanPostPagoMegas(String nombrePro, String cedulaPro, 
            String ciudadPro, String marcaCelular, String modeloCelular, 
            String numeroCelular, double mg, double cg, double t) {
        super(nombrePro, cedulaPro, ciudadPro, marcaCelular, modeloCelular, 
                numeroCelular);
        megasGg = mg;
        costoGiga = cg;
        tarifaBase = t;
    }
    
    public void estabelcerMegasGg(double m){
        megasGg = m;
    }
    public void establecerCostoGiga(double c){
        costoGiga = c;
    }
    public void establecerTarifaBase(double t){
        tarifaBase = t;
    }
    
    public double obtenerMegasGg(){
        return megasGg;
    }
    public double obtenerCostoGiga(){
        return costoGiga;
    }
    public double obtenerTarifaBase(){
        return tarifaBase;
    }
    
    @Override
    public void pagoMensual() {
        pagoMensual = (megasGg * costoGiga) + tarifaBase;
    }
    
    @Override
    public String toString() {
        String c = String.format("\n-------PLAN POST PAGO MEGAS-------\n"
                + super.toString() + "\nFactura\n"
                + "\tNumero de Megas (GB): %.2f\n"
                + "\tCosto del GB: %.2f\n"
                + "\tTarifa base: %.2f\n"
                + "\tPago mensual: %.2f\n",
                obtenerMegasGg(), 
                obtenerCostoGiga(),
                obtenerTarifaBase(),
                obtenerPagoMensual()
        );
        return c;
    }
}
