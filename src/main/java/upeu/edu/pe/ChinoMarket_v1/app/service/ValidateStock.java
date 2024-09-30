
package upeu.edu.pe.ChinoMarket_v1.app.service;

import java.util.List;
import org.springframework.stereotype.Service;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.StockEntity;

@Service
public class ValidateStock {
    private final StockService stockService;

    public ValidateStock(StockService stockService) {
        this.stockService = stockService;
    }
    
    private boolean existBalance(ProductEntity product){
        List<StockEntity> stockList = stockService.getStockByProductEntity(product);
        return stockList.isEmpty() ? false : true;
    }
    
    public StockEntity calculateBalance(StockEntity stock){
        
        if(stock.getEntradas() != 0){
            if(existBalance(stock.getProductEntity())){
                List<StockEntity> stockList = stockService.getStockByProductEntity(stock.getProductEntity());
                Integer balance = stockList.get(stockList.size()-1).getBalance();
                stock.setBalance(balance + stock.getEntradas());
            }else{
                stock.setBalance(stock.getEntradas());
            }
            
        }else{
            List<StockEntity> stockList = stockService.getStockByProductEntity(stock.getProductEntity());
                Integer balance = stockList.get(stockList.size()-1).getBalance();
                stock.setBalance(balance - stock.getSalidas());
                    
        }
        
        return stock;
    }
}