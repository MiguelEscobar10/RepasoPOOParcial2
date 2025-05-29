import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Plato plato1 = new Plato("Wendys", "Big Bacon", 7.99);
        Plato plato2 = new Plato("El Rinconcito", "Tapa Arterias", 6);
        Plato plato3 = new Plato("Tortas la China", "La triple", 3);

        List<Plato> menu = new ArrayList<Plato>();
        menu.add(plato1);
        menu.add(plato2);
        menu.add(plato3);

        Map<Plato, Integer> pedidoCliente = new HashMap<>();
        //pedidoCliente.put(plato1, 2);
        /*pedidoCliente.put(plato2, 2);
        pedidoCliente.put(plato3, 3);*/

        String fechaPedido = "2025-05-02"; // Ya que el cliente no me puede dar la fecha en estilo localdate
        LocalDate conversionFecha = LocalDate.parse(fechaPedido);

        PedidoComida pedido1 = new PedidoComida("Kalet", conversionFecha,0, menu,pedidoCliente);
        pedidoCliente.put(plato1, 2);

        if (pedido1.programarPedido()){
            System.out.println("Gracias por programar el pedido, te lo enviaremos");
            pedido1.imprimir();
        }else{
            System.out.println("Fecha invalida");
        }
    }
}
