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
}
