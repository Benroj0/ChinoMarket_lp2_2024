
package upeu.edu.pe.ChinoMarket_v1.app.repository;

import java.util.List;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.StockEntity;


public interface StockRepository {
 StockEntity saveStock(StockEntity stockEntity);
 List<StockEntity> getStockByProductEntity(ProductEntity productEntity);  
}