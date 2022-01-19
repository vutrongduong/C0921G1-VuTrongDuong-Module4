package vn.codegym.controller;

import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import vn.codegym.model.Blog;
import vn.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.service.ICategoryService;

import java.util.Optional;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String listBlog(Optional<String> name, Optional<Long> cateId
            , Model model, @PageableDefault(size = 2) Pageable pageable) {
        model.addAttribute("categorys", categoryService.findAll());
        if (!name.isPresent() || name.get().equals("")) {
            if (!cateId.isPresent()) {
                model.addAttribute("blogs", blogService.findAll(pageable));
            } else {
//                model.addAttribute("cateId", cateId.get());
                model.addAttribute("blogs", blogService.findByCategory(cateId.get(), pageable));
            }
        } else {
            if (!cateId.isPresent()) {
//                model.addAttribute("name", name.get());
                model.addAttribute("blogs", blogService.findByName(name.get(), pageable));
            }else {
//                model.addAttribute("name", name.get());
                model.addAttribute("blogs", blogService.findByNameAndCategory(name.get(),cateId.get(), pageable));
            }

        }


        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("categorys", categoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "create";
    }

    @PostMapping("/create")
    public ModelAndView saveBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/create");
//        modelAndView.addObject("categorys", categoryService.findAll());
        modelAndView.addObject("blog", new Blog());
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        return new ModelAndView("/edit", "blog", blogService.findById(id));
    }

    @PostMapping("/edit")
    public ModelAndView updateBlog(@ModelAttribute("blog") Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Blog blog = blogService.findById(id);
        if (blog != null) {
            ModelAndView modelAndView = new ModelAndView("/delete");
            modelAndView.addObject("blog", blog);
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete")
    public String deleteBlog(@ModelAttribute("blog") Blog blog) {
        blogService.remove(blog.getId());
        return "redirect:/blogs";
    }

    @GetMapping("/show/{id}")
    public ModelAndView showInfoBlog(@PathVariable Long id) {
        return new ModelAndView("/show", "blog", blogService.findById(id));
    }
}