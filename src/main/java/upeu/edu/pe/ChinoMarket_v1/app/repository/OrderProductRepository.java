package upeu.edu.pe.ChinoMarket_v1.app.repository;

import java.util.List;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.OrderEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.OrderProductEntity;

public interface OrderProductRepository {

    public OrderProductEntity create(OrderProductEntity orderProduct);

    public Iterable<OrderProductEntity> getOrderProducts();

    public List<OrderProductEntity> getOrdersProductByOrder(OrderEntity orderEntity);
}
