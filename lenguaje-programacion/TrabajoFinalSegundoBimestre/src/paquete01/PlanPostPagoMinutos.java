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

public class PlanPostPagoMinutos extends PlanCelular{
    
    private double minutosNacionales;
    private double costoMinutoNa;
    private double minutosInternacional;
    private double costoMinutoIn;

    public PlanPostPagoMinutos(String nombrePro, String cedulaPro, 
            String ciudadPro, String marcaCelular, String modeloCelular,
            String numeroCelular,double m,double cm,double mi,
                        double ci) {
        super(nombrePro, cedulaPro, ciudadPro, marcaCelular, 
                modeloCelular, numeroCelular);
        minutosNacionales = m;
        costoMinutoNa = cm;
        minutosInternacional = mi;
        costoMinutoIn = ci;
    }
    public void establecerMinutosNacionales(double mn){
        minutosNacionales = mn;
    }
    public void establecerCostoMinutosNa(double cmn){
        costoMinutoNa = cmn;
    }
    public void establecerMinutosInternacional(double mi){
        minutosInternacional = mi;
    }
    public void establecerCostoMinutosIn(double cmi){
        costoMinutoIn = cmi;
    }
    
    public double obtenerMinutosNacionales(){
        return minutosNacionales;
    }
    public double obtenerCostoMinutosNa(){
        return costoMinutoNa;
    }
    public double obtenerMinutosInternacional(){
        return minutosInternacional;
    }
    public double obtenerCostoMinutosIn(){
        return costoMinutoIn;
    }
    
    @Override
    public void pagoMensual() {
        pagoMensual = (minutosNacionales * costoMinutoNa) +
                (minutosInternacional * costoMinutoIn);
    }

    @Override
    public String toString() {
        String c = String.format("\n-------PLAN POST PAGO MINUTOS-------\n"
                + super.toString()+ "\nFactura\n"
                + "\tCantidad Minutos Nacionales: %.2f\n"
                + "\tCosto Minutos Nacionales: %.2f\n"
                + "\tCantidad Minutos Internacionales: %.2f\n"
                + "\tCosto Minutos Internacionales: %.2f\n"
                + "\tValor Mensual: %.2f\n",
                obtenerMinutosNacionales(),
                obtenerCostoMinutosNa(),
                obtenerMinutosInternacional(),
                obtenerCostoMinutosIn(),
                obtenerPagoMensual());
        return c;
    }
}
