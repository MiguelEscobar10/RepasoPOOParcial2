import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class PedidoTaxi extends Pedidoabstract{

    private String origen;
    private String destino;
    private double distancia;
    private List<Plato> listaPlatosT;
    private Map<Plato, Integer> pedidoClienteT;

    public PedidoTaxi() {}

    public PedidoTaxi(String nombreCliente, LocalDate fecha, int puntos, String origen, String destino, double distancia, List<Plato> listaPlatosT, Map<Plato, Integer> pedidoClienteT) {
        super(nombreCliente, fecha, puntos);
        this.origen = origen;
        this.destino = destino;
        this.distancia = distancia;
        this.listaPlatosT = listaPlatosT;
        this.pedidoClienteT = pedidoClienteT;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public List<Plato> getListaPlatosT() {
        return listaPlatosT;
    }

    public void setListaPlatosT(List<Plato> listaPlatosT) {
        this.listaPlatosT = listaPlatosT;
    }

    public Map<Plato, Integer> getPedidoClienteT() {
        return pedidoClienteT;
    }

    public void setPedidoClienteT(Map<Plato, Integer> pedidoClienteT) {
        this.pedidoClienteT = pedidoClienteT;
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for (Map.Entry<Plato, Integer> pedido : pedidoClienteT.entrySet()) {
            total += pedido.getValue() * pedido.getKey().getPrecio();
        }
        return total + (distancia * 1.50);
    }

    public int calcularPuntos(){
        return 2 * (int)distancia;
    }

    @Override
    public void imprimir() {
        System.out.println("Pedido de taxi para: " + getNombreCliente());
        System.out.println("Origen: " + origen + ", Destino: " + destino);
        System.out.printf("Total: $%.2f\n", calcularTotal());
        System.out.println("Puntos acumulados: " + calcularPuntos());
    }
}

