package upeu.edu.pe.ChinoMarket_v1.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import upeu.edu.pe.ChinoMarket_v1.app.repository.ProductRepository;
import upeu.edu.pe.ChinoMarket_v1.app.repository.StockRepository;
import upeu.edu.pe.ChinoMarket_v1.app.repository.UserRepository;
import upeu.edu.pe.ChinoMarket_v1.app.service.ProductService;
import upeu.edu.pe.ChinoMarket_v1.app.service.StockService;
import upeu.edu.pe.ChinoMarket_v1.app.service.UploadFile;
import upeu.edu.pe.ChinoMarket_v1.app.service.UserService;
import upeu.edu.pe.ChinoMarket_v1.app.service.ValidateStock;

@Configuration
public class BeanConfig {

    @Bean
    public ProductService productService(ProductRepository productRepository, UploadFile uploadFile) {
        return new ProductService(productRepository, uploadFile);
    }

    @Bean
    public StockService stockService(StockRepository stockRepository) {
        return new StockService(stockRepository);
    }

    @Bean
    public UploadFile uploadFile() {
        return new UploadFile();
    }

    @Bean
    public ValidateStock validateStock(StockService stockService) {
        return new ValidateStock(stockService);
    }

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

}