
package upeu.edu.pe.ChinoMarket_v1.app.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.UserEntity;

//Para que las contraseñas sean seguras
public class RegisterService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public RegisterService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }
    
    public void register(UserEntity user){
        user.setContraseña(passwordEncoder.encode(user.getContraseña()));
        userService.createUser(user);
    }
    
}

