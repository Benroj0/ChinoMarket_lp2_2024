package upeu.edu.pe.ChinoMarket_v1.infrastructure.controller;

import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.ChinoMarket_v1.app.service.ProductService;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.UserEntity;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("apiProduct") //RUTA

public class ProductControllerApi {

    private final ProductService productService;


    public ProductControllerApi(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@RequestBody ProductEntity productEntity) throws IOException {
    return productService.saveProductApi(productEntity).toString();
    }
    
    // Mostrar productos
    @GetMapping("/show") 
    public Iterable<ProductEntity> showProduct() {
        UserEntity user = new UserEntity();
        user.setId(1);
        return productService.getProductsByUser(user);
    }

    // Editar producto
    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity editProduct(@RequestBody ProductEntity product, @PathVariable Integer id) throws IOException {
        ProductEntity productActual = productService.getProductById(id);
        productActual.setDescripcion(product.getDescripcion());
        productActual.setNombre(product.getNombre());
        productActual.setPrecio(product.getPrecio());
        productActual.setUserEntity(product.getUserEntity());
        return productService.saveProductApi(productActual);
    }

    // Eliminar producto
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
    }
}
