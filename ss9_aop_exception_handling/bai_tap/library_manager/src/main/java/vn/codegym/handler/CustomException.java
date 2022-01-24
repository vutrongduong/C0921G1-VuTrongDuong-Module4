package vn.codegym.handler;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import vn.codegym.handler.exception.BorrowException;
import vn.codegym.handler.exception.CodeException;

@ControllerAdvice
public class CustomException {
    @ExceptionHandler(BorrowException.class)
    public ModelAndView exceptionBorrow() {
        return new ModelAndView("errorBorrow");
    }

    @ExceptionHandler(CodeException.class)
    public ModelAndView exceptionCode() {
        return new ModelAndView("errorCode");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ModelAndView missingException() {
        return new ModelAndView("errorCode");
    }

    @ExceptionHandler(NumberFormatException.class)
    public ModelAndView numberFormatExceptionCode() {
        return new ModelAndView("errorCode");
    }
}
