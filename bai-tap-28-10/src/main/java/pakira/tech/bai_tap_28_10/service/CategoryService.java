package pakira.tech.bai_tap_28_10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pakira.tech.bai_tap_28_10.model.Category;
import pakira.tech.bai_tap_28_10.repository.CategoryRepository;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Lấy danh sách tất cả danh mục (phân trang)
    public Page<Category> getAllCategories(int page, int size, String keyword) {
        PageRequest pageRequest = PageRequest.of(page, size);
        if (keyword != null && !keyword.isEmpty()) {
            return categoryRepository.findByNameContaining(keyword, pageRequest);
        }
        return categoryRepository.findAll(pageRequest);
    }

    // Lưu danh mục
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }

    // Lấy danh mục theo id
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    // Xóa danh mục
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}