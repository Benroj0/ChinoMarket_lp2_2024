
package upeu.edu.pe.ChinoMarket_v1.infrastructure.adapter;

import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.UserEntity;

//HEREDAR MÉTODOS DEL CRUDREPOSITORY
public interface ProductCrudRepository extends CrudRepository<ProductEntity, Integer> {
    Iterable<ProductEntity> findByUserEntity(UserEntity userEntity);

}
