
package upeu.edu.pe.ChinoMarket_v1.infrastructure.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import upeu.edu.pe.ChinoMarket_v1.app.service.RegisterService;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.dto.UserDto;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final RegisterService registerService;      
    private final Logger log = LoggerFactory.getLogger(RegisterController.class);

    

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }
    @GetMapping
    public String register(UserDto userDto){
        return "register";
    }
    
     @PostMapping
    public String registerUser(@Valid UserDto userDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
//        user.setDateCreated(LocalDateTime.now());
//        user.setTypeUser(Type.USER);
//        user.setUsername(user.getEmail());

        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(
                    e->{ log.info( "Error {}", e.getDefaultMessage() ); }
            );
            return "register";
        }
        registerService.register(userDto.userDtoToUser());
        redirectAttributes.addFlashAttribute("success", "Usuario creado correctamente");
        return "redirect:/login";
    }
    
    
}