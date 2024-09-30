package upeu.edu.pe.ChinoMarket_v1.infrastructure.adapter;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.ChinoMarket_v1.app.repository.ProductRepository;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.UserEntity;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final ProductCrudRepository productCrudRepository; 

    public ProductRepositoryImpl(ProductCrudRepository productCrudRepository) {
        this.productCrudRepository = productCrudRepository;
    }
    
    @Override
    public Iterable<ProductEntity> getProducts() {
      return productCrudRepository.findAll();
    }

    @Override
    public Iterable<ProductEntity> getProductsByUser(UserEntity user) {
           return productCrudRepository.findByUserEntity(user);
    }
    @Override
    public ProductEntity getProductById(Integer id) {
       return productCrudRepository.findById(id).get();
    }

    @Override
    public ProductEntity saveProduct(ProductEntity product) {
      return productCrudRepository.save(product);
    }

    @Override
    @Transactional
    public boolean deleteProductById(Integer id) {
        productCrudRepository.deleteById(id);
        return true; 
    }
    
}