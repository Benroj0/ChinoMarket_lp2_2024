
package upeu.edu.pe.ChinoMarket_v1.infrastructure.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import upeu.edu.pe.ChinoMarket_v1.app.service.StockService;
import upeu.edu.pe.ChinoMarket_v1.app.service.ValidateStock;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.StockEntity;

@Controller
@RequestMapping("/admin/products/stock")
public class StockController {
    private final StockService stockService;
    private final ValidateStock validateStock;

    public StockController(StockService stockService, ValidateStock validateStock) {
        this.stockService = stockService;
        this.validateStock = validateStock;
    }
    @GetMapping("/{id}")
    public List<StockEntity> show(@PathVariable Integer id) {
        ProductEntity product = new ProductEntity();
        product.setId(id);
        return stockService.getStockByProductEntity(product);
        
    }
    @GetMapping("create-unit-product/{id}")
    public String create(@PathVariable Integer id, Model model){
        model.addAttribute("idproduct", id);
      return"admin/stock/create";  
    } 
    
    @PostMapping("save-unit-product")
    public String save(StockEntity stock, @RequestParam("idproduct") Integer idproduct){
      stock.setDescripcion("entradas");
      ProductEntity product = new ProductEntity();
      product.setId(idproduct);
      stock.setProductEntity(product);
      stockService.saveStock(validateStock.calculateBalance(stock));
      return "redirect:/admin";
    }
}
