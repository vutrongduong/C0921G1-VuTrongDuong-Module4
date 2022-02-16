package vn.codegym.service;

import vn.codegym.model.User;

public interface IUserService {
    User findByUsername(String username);
}
