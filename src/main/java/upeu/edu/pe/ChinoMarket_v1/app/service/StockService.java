
package upeu.edu.pe.ChinoMarket_v1.app.service;

import java.util.*;
import org.springframework.stereotype.Service;
import upeu.edu.pe.ChinoMarket_v1.app.repository.StockRepository;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.StockEntity;

@Service
public class StockService {
   private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }
   public StockEntity saveStock(StockEntity stockEntity){
       return stockRepository.saveStock(stockEntity);
   }
   public List<StockEntity> getStockByProductEntity(ProductEntity productEntity){
     return stockRepository.getStockByProductEntity(productEntity);
   }
   
}