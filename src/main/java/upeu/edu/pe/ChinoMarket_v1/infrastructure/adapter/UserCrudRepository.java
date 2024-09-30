
package upeu.edu.pe.ChinoMarket_v1.infrastructure.adapter;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.UserEntity;

public interface UserCrudRepository extends CrudRepository<UserEntity, Integer> {
    
    public Optional<UserEntity> findByEmail(String email);
    
}
