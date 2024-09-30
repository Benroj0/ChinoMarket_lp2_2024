package upeu.edu.pe.ChinoMarket_v1.infrastructure.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.ChinoMarket_v1.app.repository.UserRepository;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.UserEntity;

@Repository
public class UserRepositoryImpl implements UserRepository {
    
    @Autowired
    private UserCrudRepository userCrudRepository;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userCrudRepository.save(userEntity);
    }

    @Override
    public UserEntity findByEmail(String email) {
        return userCrudRepository.findByEmail(email).orElse(null);
    }

    @Override
    public UserEntity findById(Integer id) {
        return userCrudRepository.findById(id).orElse(null); 
    }
}
