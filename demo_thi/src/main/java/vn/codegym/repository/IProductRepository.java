package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.model.Product;

public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT * FROM  Product where `name` like concat('%',:name,'%') and price like concat('%',:price,'%')  and category_id like concat('%',:categoryId,'%') and color like concat('%',:color,'%')", nativeQuery = true)
    Page<Product> search(@Param("name") String name,
                                  @Param("price") String price,
                                  @Param("categoryId") String categoryId,
                                  @Param("color") String color,
                                  Pageable pagle);
}
