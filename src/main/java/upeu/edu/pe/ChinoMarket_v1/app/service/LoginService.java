
package upeu.edu.pe.ChinoMarket_v1.app.service;

import org.springframework.stereotype.Service;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.TypeUser;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.UserEntity;

@Service
public class LoginService {
    
 private final UserService userService;

    public LoginService(UserService userService) {
        this.userService = userService;
    }
    
    //retorna true si encuentra el user
    public boolean existUser(String email){
        try {
            UserEntity user = userService.findByEmail(email);
        }catch(Exception e){
            return false;
        }
        return true;
    }
    //Obtener el id del usuario
    public Integer getUserId(String email){
        try{
            return userService.findByEmail(email).getId();
        }catch (Exception e){
            return 0;
        }
    }
     //Obtener tipo de usuario
    public TypeUser getUserType(String email){
        return userService.findByEmail(email).getTypeUser();
    }
     //Obtener el user por email
    public UserEntity getuser(String email){
        try{
            return userService.findByEmail(email);
        }catch (Exception e){
            return new UserEntity();
        }
    }
    //Obtener el user por id
    public UserEntity getUser(Integer id){
        try{
            return userService.findById(id);
        }catch (Exception e){
            return new UserEntity();
        }
    }
}