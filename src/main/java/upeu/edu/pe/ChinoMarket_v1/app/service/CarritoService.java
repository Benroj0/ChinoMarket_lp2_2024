
package upeu.edu.pe.ChinoMarket_v1.app.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import upeu.edu.pe.ChinoMarket_v1.app.domain.ItemCart;

public class CarritoService {
    private List<ItemCart> itemCarts;
    private HashMap<Integer, ItemCart> itemCartHashMap;

    public CarritoService() {
        this.itemCartHashMap = new HashMap<>();
        this.itemCarts = new ArrayList<>();
    }

    // Método que agrega un nuevo producto y lo actualiza en paralelo la lista en el for
    public void addItemCart(Integer idProducto, String nombreProducto, Integer quantity, BigDecimal precio) {
        ItemCart itemCart = new ItemCart(idProducto, nombreProducto, quantity, precio);
        itemCartHashMap.put(itemCart.getIdProducto(), itemCart);
        fillList();
    }

    // Método que calcula el total del carrito
    public BigDecimal getTotalCart() {
        BigDecimal total = BigDecimal.ZERO;
        for (ItemCart itemCart : itemCarts) {
            total = total.add(itemCart.getTotalPriceItem());
        }
        return total;
    }

    // Método que elimina un producto agregado
    public void removeItemCart(Integer idProducto) {
        itemCartHashMap.remove(idProducto);
        fillList();
    }

    // Método que agrega en un forEach los itemCarts
    private void fillList() {
        itemCarts.clear();
        itemCartHashMap.forEach(
                (integer, itemCart) -> itemCarts.add(itemCart)
        );
    }

    // Método que lista el carrito al procesar la orden
    public void removeAllItemCart() {
        itemCartHashMap.clear();
        itemCarts.clear();
    }

    // Para observar el proceso del item cart en consola
    public List<ItemCart> getItemCarts() {
        return itemCarts;
    }
}
