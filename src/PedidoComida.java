import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class PedidoComida extends Pedidoabstract {
    private List<Plato> listaPlatos;
    private Map<Plato, Integer> pedidoCliente;

    public PedidoComida() {
    }

    public PedidoComida(String nombreCliente, LocalDate fecha, int puntos, List<Plato> listaPlatos, Map<Plato, Integer> pedidoCliente) {
        super(nombreCliente, fecha, puntos);
        this.listaPlatos = listaPlatos;
        this.pedidoCliente = pedidoCliente;
    }

    public List<Plato> getListaPlatos() {
        return listaPlatos;
    }

    public void setListaPlatos(List<Plato> listaPlatos) {
        this.listaPlatos = listaPlatos;
    }

    public Map<Plato, Integer> getPedidoCliente() {
        return pedidoCliente;
    }

    public void setPedidoCliente(Map<Plato, Integer> pedidoCliente) {
        this.pedidoCliente = pedidoCliente;
    }

    @Override
    public double calcularTotal() {
        double total = 0;
        for(Map.Entry<Plato, Integer> pedido : pedidoCliente.entrySet()) { // integer es la cantidad del plato
            total += pedido.getValue() * pedido.getKey().getPrecio();
            System.out.println("Su total es: " + total + "$");
        }
        return total;
    }

    @Override
    public int calcularPuntos() {
        int puntos = 0;
        return puntos;
    }

    public double calcularEnvio(){
        return 0;
    }

    @Override
    public void imprimir(){
        System.out.println("Detalle del pedido:");
        System.out.println("Nombre del cliente: " + getNombreCliente());
        System.out.println("Fecha: " + getFecha());
        System.out.println("Total: " + calcularTotal() + "$");
        //Detalles que estan en el map
        for(Map.Entry<Plato, Integer> pedido : pedidoCliente.entrySet()) {
            System.out.println("Plato: " + pedido.getKey().getNombre() + " - " + pedido.getValue());
            pedido.getKey().imprimir();
        }


    }
}
