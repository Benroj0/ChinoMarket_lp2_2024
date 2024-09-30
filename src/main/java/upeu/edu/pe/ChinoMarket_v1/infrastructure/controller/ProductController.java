package upeu.edu.pe.ChinoMarket_v1.infrastructure.controller;

import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import upeu.edu.pe.ChinoMarket_v1.app.service.ProductService;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.UserEntity;

@Controller
@RequestMapping("admin/product")
public class ProductController {

    private final ProductService productService; 
    private final Logger log = LoggerFactory.getLogger(ProductController.class);

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // Crear nuevo producto
    @GetMapping("/create")
    public String create(){
        return "admin/products/create";
       }

    // Guardar producto
    @PostMapping("/saveProduct")
    public String saveProduct(ProductEntity product, @RequestParam("img") MultipartFile multipartFile) throws IOException {
        log.info("Nombre del producto {}", product);
        productService.saveProduct(product, multipartFile);
        return "redirect:/admin";   
    }

    // Mostrar productos
    @GetMapping("/show")
    public String showProduct(Model model){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1);
        Iterable<ProductEntity> products = productService.getProductsByUser(userEntity);
        model.addAttribute("products", products); 
        return "admin/products/show";
    }

    // Editar producto
    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable Integer id, Model model){
        ProductEntity product = productService.getProductById(id);
        log.info("Producto obtenido: {}", product);
        model.addAttribute("product", product);
        return "admin/products/edit";
    }

    // Eliminar producto
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Integer id){
        productService.deleteProductById(id);
        return "redirect:/admin";
    }
}
