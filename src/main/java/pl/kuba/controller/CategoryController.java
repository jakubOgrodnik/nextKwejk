package pl.kuba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kuba.dao.CategoryDao;
import pl.kuba.dao.GifDao;
import pl.kuba.model.Category;
import pl.kuba.model.Gif;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryDao categoryDao;
    @Autowired
    GifDao gifDao;

    @GetMapping("/add/category")
    public String addCategory (ModelMap modelMap){
        modelMap.addAttribute("category", new Category());
        return "add/newcategory";
    }
    @PostMapping("/createcat")
    public String addCategory(@ModelAttribute Category category){
        categoryDao.saveCategory(category);
        return "redirect:success";
    }
    @GetMapping("/categories")
    public String showAllCategories(@ModelAttribute Category category,@ModelAttribute Gif gif ,ModelMap modelMap){
        List<Category> categories = categoryDao.getAllCategories();
        modelMap.addAttribute("categories", categories);
        return "categories";
    }
    @GetMapping("/category/{id}")
    public String categoriesDetails (@ModelAttribute Category category, @ModelAttribute Gif gif,ModelMap modelMap) {
        List<Category> categories = categoryDao.findById(category.getId());
        modelMap.addAttribute("categories", categories);
        modelMap.put("gifs", gifDao.findByCategoryId(category.getId()));
        return "category";
    }
}
