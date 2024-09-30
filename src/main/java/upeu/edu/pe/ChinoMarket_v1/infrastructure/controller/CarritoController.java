package upeu.edu.pe.ChinoMarket_v1.infrastructure.controller;

import jakarta.servlet.http.HttpSession;
import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import upeu.edu.pe.ChinoMarket_v1.app.service.CarritoService;

@Controller
@RequestMapping("/user/carrito")
public class CarritoController {

    private final CarritoService carritoService;
    private final Logger log = LoggerFactory.getLogger(CarritoController.class);

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @PostMapping("add-product")
    public String addProductCarrito(@RequestParam Integer quantity, @RequestParam Integer idProducto, @RequestParam String nombreProducto, @RequestParam BigDecimal precio) {
        carritoService.addItemCart(idProducto, nombreProducto, quantity, precio);
        showCarrito();
        return "redirect:/home";
    }

    // Ver en consola
    private void showCarrito() {
        carritoService.getItemCarts().forEach(itemCart -> log.info("Item carrito {}", itemCart));
    }

    @GetMapping("/get-carrito")
    public String getCarrito(Model model, HttpSession httpSession) {
        showCarrito();
        model.addAttribute("carrito", carritoService.getItemCarts());
        model.addAttribute("total", carritoService.getTotalCart());
        model.addAttribute("id", httpSession.getAttribute("iduser").toString());
        return "user/carrito/carrito";
    }

    @GetMapping("/delete-item-carrito/{id}")
    public String deleteItemCarrito(@PathVariable Integer id) {
        carritoService.removeItemCart(id);
        return "redirect:/user/carrito/get-carrito";
    }
}
