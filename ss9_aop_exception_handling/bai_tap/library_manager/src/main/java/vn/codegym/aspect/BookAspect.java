package vn.codegym.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import vn.codegym.model.CodeBook;

@Aspect
@Component
public class BookAspect {

    @AfterReturning(value = "execution(* vn.codegym.service.impl.CodeBookService.add(..))")
    public void borrowBook(JoinPoint joinPoint) {
        for (Object arg : joinPoint.getArgs()) {
            if (!(arg instanceof CodeBook)) {
                continue;
            }
            CodeBook book = (CodeBook) arg;
            System.err.println("book with name " + book.getBook().getName() + " just borrowed with code : " + book.getCode());
        }
    }

    @AfterReturning(value = "execution(* vn.codegym.service.impl.CodeBookService.delete(..))")
    public void returnBook(JoinPoint joinPoint) {
        for (Object arg : joinPoint.getArgs()) {
            if (!(arg instanceof CodeBook)) {
                continue;
            }
            CodeBook book = (CodeBook) arg;
            System.err.println("Book with name " + book.getBook().getName() + " just borrowed with code : " + book.getCode());
        }
    }

    @After(value = "execution(* vn.codegym.service.impl.*.*(..))")
    public void action(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        System.err.println("Customer just made : " + name);
    }
}
