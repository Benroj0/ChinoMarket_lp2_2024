
package upeu.edu.pe.ChinoMarket_v1.infrastructure.controller;

import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import upeu.edu.pe.ChinoMarket_v1.app.domain.ItemCart;
import upeu.edu.pe.ChinoMarket_v1.app.service.CarritoService;
import upeu.edu.pe.ChinoMarket_v1.app.service.OrderProductService;
import upeu.edu.pe.ChinoMarket_v1.app.service.OrderService;
import upeu.edu.pe.ChinoMarket_v1.app.service.ProductService;
import upeu.edu.pe.ChinoMarket_v1.app.service.StockService;
import upeu.edu.pe.ChinoMarket_v1.app.service.UserService;
import upeu.edu.pe.ChinoMarket_v1.app.service.ValidateStock;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.OrderEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.OrderProductEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.StockEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.UserEntity;

@Controller
@RequestMapping("/user/order")
public class OrderController {

    private final CarritoService carritoService;
    private final UserService userService;
    private final OrderService orderService;
    private final ProductService productService;
    private final OrderProductService orderProductService;
    private final Integer entradas = 0;
    private final StockService stockService;
    private final ValidateStock validateStock;

    private final Logger log = LoggerFactory.getLogger(OrderController.class);

    public OrderController(CarritoService carritoService, UserService userService, OrderService orderService, ProductService productService, OrderProductService orderProductService, StockService stockService, ValidateStock validateStock) {
        this.carritoService = carritoService;
        this.userService = userService;
        this.orderService = orderService;
        this.productService = productService;
        this.orderProductService = orderProductService;
        this.stockService = stockService;
        this.validateStock = validateStock;
    }

    @GetMapping("/sumary-order")
    public String showSumaryOrder(Model model, HttpSession httpSession) {
        UserEntity user = userService.findById(Integer.parseInt(httpSession.getAttribute("iduser").toString()));
        model.addAttribute("cart", carritoService.getItemCarts());
        model.addAttribute("total", carritoService.getTotalCart());
        model.addAttribute("user", user);
        model.addAttribute("id", httpSession.getAttribute("iduser").toString());
        model.addAttribute("nombre", httpSession.getAttribute("name").toString());

        return "user/sumaryorder";

    }

    @GetMapping("/create-order")
    public String createOrder(RedirectAttributes attributes, HttpSession httpSession) {
        UserEntity user = userService.findById(Integer.parseInt(httpSession.getAttribute("iduser").toString()));
        OrderEntity order = new OrderEntity();
        order.setFechaCreado(LocalDateTime.now());
        order.setStatus("Proceso");
        order.setUser(user);
        log.info("order", order);
        //guardar Order
        order = orderService.createOrder(order);

        List<OrderProductEntity> orderProduct = new ArrayList<>();
        for (ItemCart itemCart : carritoService.getItemCarts()) {
            orderProduct.add(new OrderProductEntity(productService.getProductById(itemCart.getIdProducto    ()),
                    itemCart.getQuantity(),
                    order));
        }

        orderProduct.forEach(
                op -> {
                    orderProductService.create(op);
                    StockEntity stock = new StockEntity();
                    stock.setDescripcion("salida");
                    stock.setEntradas(entradas);
                    stock.setProductEntity(op.getProductEntity());
                    stock.setSalidas(op.getQuantity());
                    stockService.saveStock(validateStock.calculateBalance(stock));
                }
        );
        

        carritoService.removeAllItemCart();
        attributes.addFlashAttribute("id", httpSession.getAttribute("iduser").toString());
        attributes.addFlashAttribute("nombre", httpSession.getAttribute("name").toString());
        return "redirect:/home";
    }

}