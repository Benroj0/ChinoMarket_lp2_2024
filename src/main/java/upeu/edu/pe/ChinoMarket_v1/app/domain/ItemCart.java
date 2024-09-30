
package upeu.edu.pe.ChinoMarket_v1.app.domain;

import java.math.BigDecimal;

public class ItemCart {
  private Integer idProducto;
  private String nombreProducto;
  private Integer quantity;
  private BigDecimal precio;


public BigDecimal getTotalPriceItem(){
    return precio.multiply(BigDecimal.valueOf(quantity));
}

    public ItemCart(Integer idProducto, String nombreProducto, Integer quantity, BigDecimal precio) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.quantity = quantity;
        this.precio = precio;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }


    @Override
    public String toString() {
        return "ItemCart{" + "idProduct=" + idProducto + ", nombreProduct=" + nombreProducto + ", quantity=" + quantity + ", precio=" + precio + '}';
    }


}