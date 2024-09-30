package upeu.edu.pe.ChinoMarket_v1.app.repository;

import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.UserEntity;

public interface ProductRepository {

    Iterable<ProductEntity> getProducts();
    Iterable<ProductEntity> getProductsByUser(UserEntity userEntity);
    ProductEntity getProductById(Integer id);
    ProductEntity saveProduct(ProductEntity productEntity);
    boolean deleteProductById(Integer id);
    
}
