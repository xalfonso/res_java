package ensayo2bimestre;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

abstract class Trabajo {

    protected int identificador;
    protected String descripcion;
    protected float horas;
    protected boolean finalizado;
    public static int proximoIdentificador = 0;
    protected final int plazos;

    //constructor de la clase trabajo
    public Trabajo(String descripcion, int plazos) {
        this.identificador = proximoIdentificador;
        proximoIdentificador++;
        this.descripcion = descripcion;
        this.horas = 0;
        this.finalizado = false;
        this.plazos = plazos;
    }

    //devuelve el identificador
    public int getIdentificador() {
        return this.identificador;
    }

    //establece el identificador
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    //devuelve la descripcion
    public String getDescripcion() {
        return this.descripcion;
    }

    //establece la descripcion
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //devuelvee las horas
    public float getHoras() {
        return this.horas;
    }

    //establece las horas
    public void setHoras(float horas) {
        this.horas = horas;
    }

    //metodo para aumentar las horas de trabajo
    public void aumentarHoras(float aumento) {
        this.horas += aumento;
    }

    //devuelve un valor finalizado 
    public boolean getFinalizado() {
        return this.finalizado;
    }

    //establece el fin
    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }

    //metodo para calcular el precio fijo
    public float calcularPrecioFijo() {
        return this.horas * 30;
    }

    public int getPlazos(){
        return this.plazos;
    }
    
    //metofo abstracto reusable para calcular el costo especifico 
    abstract public float calcularCostoEspecifico();

    @Override//Indica que el metodo sobrescribe al metodo de la superclase.
    public String toString() {
        return "Trabajo{" + "identificador=" + identificador + ", descripcion=" + descripcion + ", horas=" + horas + ", finalizado=" + finalizado + ", plazos=" + plazos + '}';
    }

}

abstract class Reparacion extends Trabajo {

    protected float costoMaterial;

    public Reparacion(float costoMaterial, String descripcion, int plazos) {
        super(descripcion, plazos);
        this.costoMaterial = costoMaterial;
    }

    //devuelve el costo del material
    public float getCostoMaterial() {
        return this.costoMaterial;
    }

    //establecer el costo del material
    public void setCostoMaterial(float costoMaterial) {
        this.costoMaterial = costoMaterial;
    }

    //metodo para aumentar el costo del material
    public void aumentarCostoMaterial(float aumento) {
        this.costoMaterial += aumento;

    }

    @Override//Indica que el metodo sobrescribe al metodo de la superclase.
    public String toString() {
        return super.toString() + "Reparacion{" + "costoMaterial=" + costoMaterial + '}';
    }

}

class ReparacionMecanica extends Reparacion {

    public ReparacionMecanica(float costoMaterial, String descripcion) {
        super(costoMaterial, descripcion, 14);
    }

    @Override//Indica que el metodo sobrescribe al metodo de la superclase.
    //metodo para calcular el costo especifico de una reparacion mecanica
    public float calcularCostoEspecifico() {
        return this.calcularPrecioFijo() + this.costoMaterial * 1.1f;
    }

}

class ReparacionChapaPintura extends Reparacion {

    public ReparacionChapaPintura(float costoMaterial, String descripcion) {
        super(costoMaterial, descripcion, 21);
    }

    @Override//Indica que el metodo sobrescribe al metodo de la superclase.
    //metodo para calcular el costo especifico de una reparacion chapa y pintura
    public float calcularCostoEspecifico() {
        return this.calcularPrecioFijo() + this.costoMaterial * 1.3f;
    }
}
//Revision se hereda de la clase Trabajo 

class Revision extends Trabajo {

    public Revision(String descripcion) {
        super(descripcion, 7);
    }

    @Override//Indica que el metodo sobrescribe al metodo de la superclase.
    //metodo para calcular el costo especifico de revision
    public float calcularCostoEspecifico() {
        return this.calcularPrecioFijo() + 20;
    }
}
//clase para guardar todos los diferentes tipos de trabajo

class Empresa {

    private Trabajo[] trabajos;

    public Empresa() {
        this.trabajos = new Trabajo[50];
    }

    //metodo para ingresar un trabajo adicional
    public void adicionarTrabajo(Trabajo trabajo) {
        this.trabajos[trabajo.getIdentificador()] = trabajo;
    }

    //metodo para aumentar las horas a un trbajo determinado, siempre y cuando este no este finalizado.
    public void aumentarHoras(int identificadorTrabajo, float aumento) throws TrabajoFinalizadoException {
        if (this.trabajos[identificadorTrabajo].getFinalizado()) {
            throw new TrabajoFinalizadoException("No se puede aumentar las horas porque el trabajo está finalizado");
        }
        this.trabajos[identificadorTrabajo].aumentarHoras(aumento);
    }

    //metodo para aumentar el costo del material a un trbajo determinado.
    public void aumentarCostoMaterial(int identificadorTrabajo, float aumento) throws TrabajoFinalizadoException, TrabajoNoTypeCorrectException {
        if (this.trabajos[identificadorTrabajo].getFinalizado()) {
            throw new TrabajoFinalizadoException("No se puede aumentar el costo del material porque el trabajo está finalizado");
        }
        //instancia  reparacion de la clase Trabajo
        if ((this.trabajos[identificadorTrabajo] instanceof Reparacion) == false) {
            throw new TrabajoNoTypeCorrectException("No se puede aumentar el costo del material porque el trabajo no es una reparación");
        }
        //hace un castin para poder usar la clase reparacion dentro del arreglo atrbajos.
        ((Reparacion) this.trabajos[identificadorTrabajo]).aumentarCostoMaterial(aumento);
    }

    //metodo para finalizar un trabajo
    public void finalizarTrabajo(int identificadorTrabajo) {
        this.trabajos[identificadorTrabajo].setFinalizado(true);

    }

    //metodo para obtener un trabajo
    public Trabajo obtenerTrabajo(int identificarTrabajo) {
        return this.trabajos[identificarTrabajo];
    }

    public Trabajo[] getTrabajos() {
        return trabajos;
    }
    public int obtenerPlazo(int identificadorTrbajo){
        return this.trabajos[identificadorTrbajo].getPlazos();
    }
    
}
//clase para generar los datos de forma aleatoria

class GeneradorDato {

    private Random random;

    public GeneradorDato() {
        this.random = new Random();
    }

    //metodo para generar la descripcion de un trabajo de forma aleatoria
    public String generarDescripcion() {
        return "Descripcion-" + this.random.nextInt(50);
    }

    //return: ReparacionMecanica, 1: ReparacionChapaPintura, 2: Revision
    //metodo para generar el tipo de trabajo de forma aleatoria
    public int generarTipoTrabajo() {
        return this.random.nextInt(3);
    }

    //metodo para generar el costo del material para un trabajo de forma aleatoria
    public float generarCostoMaterial() {
        float min = 10.0f;
        float max = 150.0f;
        return this.random.nextFloat() * (max - min) + min;
    }

    //metodo para generar las horas adicionales a un trabajo de forma aleatoria
    public float generarHorasAdicionales() {
        float min = 4.5f;
        float max = 40.4f;
        return this.random.nextFloat() * (max - min) + min;

    }

    //metodo para generar el aumento de costo del material para un trabajo determinado de forma aleatoria
    public float generarCostoMaterialAumento() {
        float min = 10.5f;
        float max = 50.4f;
        return this.random.nextFloat() * (max - min) + min;

    }

    //metodo para generar un trabajo seleccionado de forma aleatoria
    public int generarTrabajoSeleccionado(int maxTrabajos) {
        return this.random.nextInt(maxTrabajos);
    }
}
//excepcion que se lanza cuando intentamos anadir horas a un trabajo finalizado

class TrabajoFinalizadoException extends Exception {

    public TrabajoFinalizadoException(String string) {
        super(string);
    }

}

class TrabajoNoTypeCorrectException extends Exception {

    public TrabajoNoTypeCorrectException(String string) {
        super(string);
    }

}

public class Ensayo2Bimestre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Empresa empresa = new Empresa();
        GeneradorDato generadorDato = new GeneradorDato();

        int opcion = -1;
        while (opcion != 0) {
            System.out.println("*********menu*********");
            System.out.println("Para registrar el trabajo presione 1.");
            System.out.println("para aumentar las horas presione 2.");
            System.out.println("Para aumentar el coste del material presione 3.");
            System.out.println("Para finalizar trabajo presione 4.");
            System.out.println("Para mostrar trabajo presione 5.");
            System.out.println("Para consultar plazo presione 6.");
            System.out.println("Para mostrar todos los trabajos presione 7.");
            System.out.println("Presione 0 para salir");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Usted ha seleccionado 1");
                    int tipoTrabajo = generadorDato.generarTipoTrabajo();
                    float costMaterial = generadorDato.generarCostoMaterial();
                    String descripcion = generadorDato.generarDescripcion();
                    Trabajo trabajoNuevo;
                    if (tipoTrabajo == 0) {
                        trabajoNuevo = new ReparacionMecanica(costMaterial, descripcion);
                    } else {
                        if (tipoTrabajo == 1) {
                            trabajoNuevo = new ReparacionChapaPintura(costMaterial, descripcion);
                        } else {
                            trabajoNuevo = new Revision(descripcion);
                        }
                    }

                    empresa.adicionarTrabajo(trabajoNuevo);
                    break;
                case 2:
                    System.out.println("Usted ha seleccionado 2");
                    if (Trabajo.proximoIdentificador > 0) {
                        int identificadorTrabajo = generadorDato.generarTrabajoSeleccionado(Trabajo.proximoIdentificador);
                        float horasAumentar = generadorDato.generarHorasAdicionales();

                        try {
                            empresa.aumentarHoras(identificadorTrabajo, horasAumentar);
                        } catch (TrabajoFinalizadoException exception) {
                            System.out.println(exception.getMessage());
                        }
                    } else {
                        System.out.println("no existe ningun trabajo registrado");
                    }
                    break;
                case 3:
                    System.out.println("Usted ha seleccionado 3");
                    if (Trabajo.proximoIdentificador > 0) {
                        int identificadorTrabajoAumento = generadorDato.generarTrabajoSeleccionado(Trabajo.proximoIdentificador);
                        float aumentarCosto = generadorDato.generarCostoMaterial();
                        try {
                            empresa.aumentarCostoMaterial(identificadorTrabajoAumento, aumentarCosto);
                        } catch (TrabajoFinalizadoException | TrabajoNoTypeCorrectException exception) {
                            System.out.println(exception.getMessage());
                        }
                    } else {
                        System.out.println("no existe ningun trabajo registrado");
                    }
                    break;
                case 4:
                    System.out.println("Usted ha seleccionado 4");
                    if (Trabajo.proximoIdentificador > 0) {
                        int identificadorTrabajoFinalizado = generadorDato.generarTrabajoSeleccionado(Trabajo.proximoIdentificador);
                        empresa.finalizarTrabajo(identificadorTrabajoFinalizado);
                    } else {
                        System.out.println("no existe ningun trabajo registrado");
                    }
                    break;
                case 5:
                    System.out.println("Usted ha seleccionado 5");
                    if (Trabajo.proximoIdentificador > 0) {
                        int identificadorTrabajoMostrar = generadorDato.generarTrabajoSeleccionado(Trabajo.proximoIdentificador);

                        System.out.println("Identificador Generado:" + identificadorTrabajoMostrar);
                        System.out.println(Arrays.toString(empresa.getTrabajos()));
                        Trabajo trabajo = empresa.obtenerTrabajo(identificadorTrabajoMostrar);
                        System.out.println(trabajo.toString());
                    } else {
                        System.out.println("no existe ningun trabajo registrado");
                    }
                    break;
                case 6:
                    System.out.println("Usted ha seleccionado 6");
                    if(Trabajo.proximoIdentificador > 0){
                    int identificadorTrabajo = generadorDato.generarTrabajoSeleccionado(Trabajo.proximoIdentificador);
                    int plazos = empresa.obtenerPlazo(identificadorTrabajo);
                    System.out.println(plazos);
                    }else{
                        System.out.println("no existe ningun trabajo registrado");
                    }
                    break;
                case 7:
                    System.out.println("Usted ha seleccionado 7");
                     if(Trabajo.proximoIdentificador > 0){
                       empresa.getTrabajos();
                     }else{
                         System.out.println("no existe ningun trabajo registrado");
                     }  
                    break;
                case 0:
                    System.out.println("el programa ha finalizado");
                    break;
                default:
                    System.out.println("Opción no válida");

            }
        }
    }
}
