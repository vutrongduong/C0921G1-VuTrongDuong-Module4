package vn.codegym.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.handler.exception.BorrowException;
import vn.codegym.handler.exception.CodeException;
import vn.codegym.model.Book;
import vn.codegym.model.CodeBook;
import vn.codegym.service.IBookService;
import vn.codegym.service.ICodeBookService;

import java.util.concurrent.ThreadLocalRandom;


@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private ICodeBookService codeBookService;

    @GetMapping
    public ModelAndView list() {
        return new ModelAndView("list", "bookList", bookService.findAll());
    }

    @GetMapping("/details/{id}")
    public ModelAndView details(@PathVariable Long id) {
        return new ModelAndView("show", "book", bookService.findById(id));
    }

    @GetMapping("/borrow/{id}")
    public String borrow(@PathVariable Long id, RedirectAttributes redirectAttributes) throws Exception {
        Book book = bookService.findById(id);
        int amount = book.getAmount();
        if (amount != 0) {
            book.setAmount(amount - 1);
            Long code = ThreadLocalRandom.current().nextLong(10000, 49999);
            codeBookService.add(new CodeBook(code, book));
            redirectAttributes.addFlashAttribute("mess", "You have successfully borrowed the book, your borrowing code is : " + code);
            return "redirect:/";
        } else {
            throw new BorrowException();
        }
    }

    @GetMapping("/return")
    public String returnBookForm() {
        return "return";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam Long code, Model model) throws CodeException {
        try {
            CodeBook codeBook = codeBookService.findByCode(code);
            Book book = bookService.findById(codeBook.getBook().getId());
            int amount = book.getAmount();
            book.setAmount(amount + 1);
            codeBookService.delete(codeBook);
            model.addAttribute("mess", "You have successfully returned the book with the code to borrow the book : " + code);
            return "return";
        } catch (MethodArgumentTypeMismatchException e) {
            throw new CodeException();
        } catch (NumberFormatException e) {
            throw new CodeException();
        } catch (Exception e) {
            throw new CodeException();
        }
    }
}
