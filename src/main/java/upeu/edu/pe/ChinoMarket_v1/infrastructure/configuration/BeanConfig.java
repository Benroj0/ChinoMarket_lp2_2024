package upeu.edu.pe.ChinoMarket_v1.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.context.WebApplicationContext;
import upeu.edu.pe.ChinoMarket_v1.app.repository.OrderProductRepository;
import upeu.edu.pe.ChinoMarket_v1.app.repository.OrderRepository;
import upeu.edu.pe.ChinoMarket_v1.app.repository.ProductRepository;
import upeu.edu.pe.ChinoMarket_v1.app.repository.StockRepository;
import upeu.edu.pe.ChinoMarket_v1.app.repository.UserRepository;
import upeu.edu.pe.ChinoMarket_v1.app.service.CarritoService;
import upeu.edu.pe.ChinoMarket_v1.app.service.LoginService;
import upeu.edu.pe.ChinoMarket_v1.app.service.LogoutService;
import upeu.edu.pe.ChinoMarket_v1.app.service.OrderProductService;
import upeu.edu.pe.ChinoMarket_v1.app.service.OrderService;
import upeu.edu.pe.ChinoMarket_v1.app.service.ProductService;
import upeu.edu.pe.ChinoMarket_v1.app.service.RegisterService;
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
    public OrderService orderService(OrderRepository orderRepository) {
        return new OrderService(orderRepository);
    }

    @Bean
    public OrderProductService orderProductService(OrderProductRepository orderProductRepository) {
        return new OrderProductService(orderProductRepository);
    }

    @Bean
    @Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
    public CarritoService carritoService() {
        return new CarritoService();
    }

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean
    public LoginService loginService(UserService userService) {
        return new LoginService(userService);
    }

    @Bean
    public LogoutService logoutService() {
        return new LogoutService();
    }

    @Bean
    public RegisterService registrationService(UserService userService, PasswordEncoder passwordEncoder) {
        return new RegisterService(userService, passwordEncoder);
    }

}
