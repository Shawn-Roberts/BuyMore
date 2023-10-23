package com.BuyMore.ProductServices.DAO

import com.BuyMore.ProductServices.Entity.Product
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class ProductDAOImpl implements ProductDAO {

    @PersistenceContext
    private EntityManager entityManager

    @Autowired
    ProductDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager
    }


    private Product productForPOC = Product.createProduct()
            .name("product")
            .description("product desc")
            .price(new BigDecimal(9.99))
            .rating(1.25)
            .build()

    @Override
    Collection<Product> findAll() {
        return List.of(productForPOC)
    }

    @Override
    Optional<Product> findById(String id) {
        return Optional.of(productForPOC)
    }

    @Override
    Collection<Product> search(String query) {
        return List.of(productForPOC)
    }

    @Override
    @Transactional
    Product saveProduct(Product product) {
        entityManager.persist(product)
        return productForPOC
    }

    @Override
    void deleteProductById(String id) {}
}
