
package upeu.edu.pe.ChinoMarket_v1.infrastructure.adapter;

import java.util.List;
import org.springframework.stereotype.Repository;
import upeu.edu.pe.ChinoMarket_v1.app.repository.StockRepository;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.StockEntity;

@Repository
public class StockRepositoryImpl implements StockRepository{
private final StockCrudRepository stockCrudRepository;

    public StockRepositoryImpl(StockCrudRepository stockCrudRepository) {
        this.stockCrudRepository = stockCrudRepository;
    }

    @Override
    public StockEntity saveStock(StockEntity stockEntity) {
        return stockCrudRepository.save(stockEntity);
    }

    @Override
    public List<StockEntity> getStockByProductEntity(ProductEntity productEntity) {
    return stockCrudRepository.getStockByProductEntity(productEntity);
    }
    
}