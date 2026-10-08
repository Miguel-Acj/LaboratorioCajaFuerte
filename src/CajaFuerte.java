public class CajaFuerte
{
    /**
     * Declaracion de los campos en private
     */
    private String numeroSerie;
    private String modelo;
    private int claveAcceso;
    private boolean estado;
    private byte intentosFallidos;
    private double capacidadMaxima;
    private double saldoActual;

    /**
     * Declaracion del constructor
     */
    public CajaFuerte(String numeroSerie, String modelo,
                      int claveAcceso, double capacidadMaxima)
    {
        this.numeroSerie = numeroSerie;
        this.modelo = modelo;
        this.claveAcceso = claveAcceso;
        this.capacidadMaxima = capacidadMaxima;
        estado = false; //la caja se encuentra serrada
        intentosFallidos = 0;
        saldoActual = 0.0;
  }
    /**
     * Declaracion del metodo Abrir caja
     */
    public void abrir(int claveIngresada)
    {
        if(intentosFallidos >= 3)
        {
            System.out.println("Caja fuerte bloqueada.");
            return;
        }
        if(estado) { System.out.println("La caja fuerte ya esta abierta.");}


        if(claveIngresada == claveAcceso)
        {
         estado = true;     //indica que la caja fue abierta
         intentosFallidos = 0;
         System.out.println("Acceso autorizado.");
        }
        else
        {
            intentosFallidos ++;    //incrementa en +1 la cantidad de intentos fallidos
            System.out.println("Clave incorrecta, intentos restantes: " +(3-intentosFallidos));
            if(intentosFallidos >= 3)
            {
            estado = false;
            System.out.println("Caja fuerte bloqueada.");
            }
        }
    }

    /**
     * Declaracion del metodo Cerrar caja fuerte
     */
    public void cerrar()
    {
        if(estado)
        {
            estado = false;
            System.out.println("Se ha cerrado la caja fuerte.");
        }
        else
        {
            System.out.println("La caja fuerte ya esta cerrada.");
        }
    }

}
