package pakira.tech.bai_tap_28_10.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pakira.tech.bai_tap_28_10.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Tìm kiếm theo tên danh mục
    Page<Category> findByNameContaining(String name, Pageable pageable);
}