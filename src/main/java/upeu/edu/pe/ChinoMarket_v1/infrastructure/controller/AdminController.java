
package upeu.edu.pe.ChinoMarket_v1.infrastructure.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import upeu.edu.pe.ChinoMarket_v1.app.service.ProductService;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.ProductEntity;

@Controller
@RequestMapping("/admin")
public class AdminController {
 
    private final ProductService productService;

    public AdminController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping
    public String home(Model model){
        Iterable<ProductEntity> products = productService.getProducts();
        model.addAttribute("products", products);
        return "admin/home";
    }
}