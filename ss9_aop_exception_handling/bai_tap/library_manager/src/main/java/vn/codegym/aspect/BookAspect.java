package vn.codegym.aspect;

import org.aspectj.lang.annotation.*;

@Aspect
public class BookAspect {
    @AfterReturning(value = "executeController()")
    public void afterController() {
        System.out.println("Ghi nhan thay doi");
    }

    @Around(value = "executeController()")
    public void aroundController() {
        System.out.println("Ghi nhan thay doi");
    }

    @Pointcut(value = "within(vn.codegym.service.impl.BookService)")
    public void executeController() {
    }
}
