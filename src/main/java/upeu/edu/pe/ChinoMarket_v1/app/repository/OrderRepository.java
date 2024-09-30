package upeu.edu.pe.ChinoMarket_v1.app.repository;

import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.OrderEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.UserEntity;

public interface OrderRepository {

    public OrderEntity createOrder(OrderEntity order);

    public Iterable<OrderEntity> getOrders();

    public Iterable<OrderEntity> getOrdersByUser(UserEntity user);
}
