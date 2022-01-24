package vn.codegym.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class BookAspect {
    //    @Around(value = "execution(* vn.codegym.service.impl.CodeBookService.add(..))" )
    //    public void borrowBook(ProceedingJoinPoint joinPoint) throws Throwable {
    //        ObjectMapper objectMapper=new ObjectMapper();
    //        Object[] arr =  joinPoint.getArgs();
    //        System.err.println("book with name" + "just borrowed with code"+ objectMapper.writeValueAsString(arr[0]));
    //    }
    @AfterReturning(value = "execution(* vn.codegym.service.impl.CodeBookService.add(..))")
    public void borrowBook() {
        System.err.println("A book has been borrowed");
    }

    @AfterReturning(value = "execution(* vn.codegym.service.impl.CodeBookService.delete(..))")
    public void returnBook() {
        System.err.println("A book has been paid");
    }

    @After(value = "execution(* vn.codegym.service.impl.*.*(..))")
    public void action(JoinPoint joinPoint) {
        String name =joinPoint.getSignature().getName();
        System.err.println("Customer just made : " + name);
    }
}
