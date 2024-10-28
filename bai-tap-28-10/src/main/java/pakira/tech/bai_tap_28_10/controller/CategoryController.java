package pakira.tech.bai_tap_28_10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pakira.tech.bai_tap_28_10.model.Category;
import pakira.tech.bai_tap_28_10.service.CategoryService;

@Controller
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // Hiển thị danh sách phân trang
    @GetMapping
    public String listCategories(Model model,
                                 @RequestParam(value = "page", defaultValue = "0") int page,
                                 @RequestParam(value = "size", defaultValue = "5") int size,
                                 @RequestParam(value = "keyword", defaultValue = "") String keyword) {
        Page<Category> categoryPage = categoryService.getAllCategories(page, size, keyword);
        model.addAttribute("categoryPage", categoryPage);
        model.addAttribute("totalPages", categoryPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "category/list";
    }

    // Hiển thị form thêm mới
    @GetMapping("/add")
    public String showAddForm(Category category) {
        return "category/form";
    }

    // Lưu danh mục mới
    @PostMapping("/save")
    public String saveCategory(Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category/form";
        }
        categoryService.saveCategory(category);
            return "redirect:/categories";
    }

    // Sửa danh mục
    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        Category category = categoryService.getCategoryById(id).orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + id));
        model.addAttribute("category", category);
        return "category/form";
    }

    // Xóa danh mục
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }
}