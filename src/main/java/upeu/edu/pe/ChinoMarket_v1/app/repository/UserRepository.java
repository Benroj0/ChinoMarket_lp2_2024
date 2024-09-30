package upeu.edu.pe.ChinoMarket_v1.app.repository;

import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.UserEntity;


public interface UserRepository {
   
    //CREA NUEVO USUARIO
    public UserEntity createUser(UserEntity userEntity);
    
    public UserEntity findByEmail(String email);
    
    public UserEntity findById(Integer id);
}
