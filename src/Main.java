public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Iniciando simulador de caja fuerte.");

        /**
         * Creacion del objeto con parametros definidos
         */
        CajaFuerte caja = new CajaFuerte("20260001l","SecureBox A1", 1234,50000.0);
        System.out.println("Caja fuerte creada correctamente.");
        caja.abrir(1234);
        caja.depositar(1500);
        caja.retirar(500);
        caja.mostrarEstado();
        caja.cerrar();
        caja.retirar(200);
    }
}
