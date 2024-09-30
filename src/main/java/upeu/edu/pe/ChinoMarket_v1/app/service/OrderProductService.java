package upeu.edu.pe.ChinoMarket_v1.app.service;

import java.util.List;
import upeu.edu.pe.ChinoMarket_v1.app.repository.OrderProductRepository;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.OrderEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.OrderProductEntity;

public class OrderProductService {

    private final OrderProductRepository orderProductRepository;

    public OrderProductService(OrderProductRepository orderProductRepository) {
        this.orderProductRepository = orderProductRepository;
    }

    public OrderProductEntity create(OrderProductEntity orderProduct) {
        return orderProductRepository.create(orderProduct);
    }

    public Iterable<OrderProductEntity> getOrderProducts() {
        return orderProductRepository.getOrderProducts();

    }

    public List<OrderProductEntity> getOrdersProductByOrder(OrderEntity orderEntity) {
        return orderProductRepository.getOrdersProductByOrder(orderEntity);
    }
}
