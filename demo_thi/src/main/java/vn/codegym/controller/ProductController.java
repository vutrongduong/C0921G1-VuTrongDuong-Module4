package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.dto.ProductDto;
import vn.codegym.model.Category;
import vn.codegym.model.Product;
import vn.codegym.service.ICategoryService;
import vn.codegym.service.IProductService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    IProductService productService;
    @Autowired
    ICategoryService categoryService;

    @GetMapping("")
    public String list(@RequestParam(defaultValue = "") String name,
                       @RequestParam(defaultValue = "") String price,
                       @RequestParam(defaultValue = "") String categoryId,
                       @RequestParam(defaultValue = "") String color, @PageableDefault(value = 1) Pageable pageable, Model model) {
        Page<Product> products = productService.search(name, price, categoryId, color, pageable);
        model.addAttribute("products", products);
        model.addAttribute("name", name);
        model.addAttribute("price", price);
        model.addAttribute("categoryId", categoryId);
        model.addAttribute("color", color);
        model.addAttribute("categories", categoryService.findAllCategory());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        ProductDto productDto = new ProductDto();
        model.addAttribute("productDto", productDto);
        List<Category> categories = categoryService.findAllCategory();
        model.addAttribute("categories", categories);
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute @Valid ProductDto productDto, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("productDto", productDto);
            List<Category> categories = categoryService.findAllCategory();
            model.addAttribute("categories", categories);
            return "create";

        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công giao dịch với khách hàng " + );
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/update/{id}")
    public String showEdit(@PathVariable Long id, Model model) {
        Product product = productService.findById(id).get();
        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        model.addAttribute("productDto", productDto);
        List<Category> categories = categoryService.findAllCategory();
        model.addAttribute("categories", categories);
        return "update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Valid ProductDto productDto, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("productDto", productDto);
            List<Category> categories = categoryService.findAllCategory();
            model.addAttribute("categories", categories);
            return "update";
        }
        Product product = new Product();
        BeanUtils.copyProperties(productDto, product);
        model.addAttribute("productDto", productDto);
        List<Category> categories = categoryService.findAllCategory();
        model.addAttribute("categories", categories);
        model.addAttribute("mess", "Update customer : " + product.getName() + " successful");
        productService.save(product);
        return "update";
    }

    @GetMapping("/delete/{id}")
    public String showDelete(@PathVariable Long id, Model model) {
        model.addAttribute("productDto", productService.findById(id).get());
        return "delete";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id,RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("messDelete", "Delete product : " + productService.findById(id).get().getName() + " successful");
        productService.delete(id);
        return "redirect:/product";
    }
}
