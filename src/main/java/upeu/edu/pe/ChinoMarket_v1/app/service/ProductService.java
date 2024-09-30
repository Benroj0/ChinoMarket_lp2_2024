package upeu.edu.pe.ChinoMarket_v1.app.service;

import java.io.IOException;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import upeu.edu.pe.ChinoMarket_v1.app.repository.ProductRepository;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.ProductEntity;
import upeu.edu.pe.ChinoMarket_v1.infrastructure.entity.UserEntity;

public class ProductService {

    private final ProductRepository productRepository;
    private final UploadFile uploadFile;
    private final Logger log = LoggerFactory.getLogger(ProductService.class);

    public ProductService(ProductRepository productRepository, UploadFile uploadFile) {
        this.productRepository = productRepository;
        this.uploadFile = uploadFile;
    }

    public Iterable<ProductEntity> getProducts() {
        return productRepository.getProducts();

    }

    public Iterable<ProductEntity> getProductsByUser(UserEntity userEntity) {
        return productRepository.getProductsByUser(userEntity);

    }

    public ProductEntity getProductById(Integer id) {
        return productRepository.getProductById(id);
    }

    public ProductEntity saveProduct(ProductEntity productEntity, MultipartFile multipartfile) throws IOException {
        if (productEntity.getId() == null) {
            UserEntity user = new UserEntity();
            user.setId(1);
            productEntity.setFechaCreado(LocalDateTime.now());
            productEntity.setFechaActualizado(LocalDateTime.now());
            productEntity.setUserEntity(user);
            productEntity.setImagen(uploadFile.upload(multipartfile));
            return productRepository.saveProduct(productEntity);
        } else {
            ProductEntity productDB = productRepository.getProductById(productEntity.getId());
            log.info("product {}", productDB);

            //ACTUALIZAR IMAGEN DEL PRODUCTO
            if (multipartfile.isEmpty()) {
                productEntity.setImagen(productDB.getImagen());
            } else {
                if (!productDB.getImagen().equals("default.jpg")) {
                    uploadFile.delete(productDB.getImagen());
                }
                productEntity.setImagen(uploadFile.upload(multipartfile));
            }
            productEntity.setCodigo(productDB.getCodigo());
            productEntity.setUserEntity(productDB.getUserEntity());
            productEntity.setFechaCreado(productDB.getFechaCreado());
            productEntity.setFechaActualizado(LocalDateTime.now());
            return productRepository.saveProduct(productEntity);
        }
    }

    public boolean deleteProductById(Integer id) {
        return productRepository.deleteProductById(id);
    }

    public ProductEntity saveProductApi(ProductEntity productEntity) throws IOException {
        if (productEntity.getId() == null) {
            UserEntity user = new UserEntity();
            user.setId(1);
            productEntity.setFechaCreado(LocalDateTime.now());
            productEntity.setFechaActualizado(LocalDateTime.now());
            productEntity.setUserEntity(user);
            return productRepository.saveProduct(productEntity);
        } else {
            ProductEntity productDB = productRepository.getProductById(productEntity.getId());
            log.info("product: {}", productDB);
            //sino se carga la imagen toma la que se le guardo al registro

            productEntity.setCodigo(productDB.getCodigo());
            productEntity.setUserEntity(productDB.getUserEntity());
            productEntity.setFechaCreado(productDB.getFechaCreado());
            productEntity.setFechaActualizado(LocalDateTime.now());
            return productRepository.saveProduct(productEntity);
        }
    }
}
