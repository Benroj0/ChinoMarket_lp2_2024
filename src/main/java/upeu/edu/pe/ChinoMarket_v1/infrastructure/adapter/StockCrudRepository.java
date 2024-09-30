package upeu.edu.pe.ChinoMarket_v1.infrastructure.adapter;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.StockEntity;

public interface StockCrudRepository extends CrudRepository<StockEntity, Integer> {

    List<StockEntity> getStockByProductEntity(ProductEntity productEntity);

}
