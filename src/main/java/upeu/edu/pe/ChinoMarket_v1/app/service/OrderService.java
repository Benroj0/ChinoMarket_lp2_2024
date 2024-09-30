
package upeu.edu.pe.ChinoMarket_v1.app.service;

import upeu.edu.pe.ChinoMarket_v1.app.repository.OrderRepository;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.OrderEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.UserEntity;

public class OrderService {
  private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public OrderEntity createOrder(OrderEntity order) {
        return orderRepository.createOrder(order);
    }

    public Iterable<OrderEntity> getOrders() {
        return orderRepository.getOrders();
    }

    public Iterable<OrderEntity> getOrdersByUser(UserEntity user) {
        return orderRepository.getOrdersByUser(user);

    }
  
}