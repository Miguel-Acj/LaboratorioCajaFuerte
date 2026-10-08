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


    /**
     * Operaciones con cantidades double
     */

    public void depositar(double cantidad)
    {
        if (!estado)
        {
            System.out.println("Primero abre la caja");
            return;
        }

        if(cantidad <= 0 || saldoActual + cantidad > capacidadMaxima)
        {
            System.out.println("Depósito no permitido");
            return;
        }

        saldoActual += cantidad;
        System.out.println("Depósito realizado");
    }

    public void retirar(double cantidad)
    {
        if(!estado)
        {
            System.out.println("Primero abre la caja");
            return;
        }

        if(cantidad <=0 || cantidad > saldoActual)
        {
            System.out.println("Retiro no permitido");
            return;
        }

        saldoActual -= cantidad;
        System.out.println("Retiro realizado");
    }


    public void mostrarEstado()
    {
        System.out.println("Modelo: " + modelo);
        System.out.println("Numero Serie: " + numeroSerie);
        System.out.print("La caja esta: " );

        if (estado)
        {
            System.out.println("abierta");
        }else
        {
            System.out.println("cerrada");
        }

        System.out.println("Intentos fallidos: " + intentosFallidos);

        if (estado)
        {
            System.out.println("Saldo: " + saldoActual);
        }else
        {
            System.out.println("Saldo: información protegida");
        }
    }
}
