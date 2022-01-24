package vn.codegym.service;

import vn.codegym.model.CodeBook;

public interface ICodeBookService {
   void add(CodeBook codeBook);
   void delete(CodeBook codeBook);
   CodeBook findByCode(Long code);
}
