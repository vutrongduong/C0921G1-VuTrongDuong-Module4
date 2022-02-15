package vn.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {
    @Id
    private String userName;
    private String password;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "user_name"))
    List<Role> roleList;
    @OneToOne(mappedBy = "user")
    Employee employee;

    public User() {
    }

    public User(String userName, String password, List<Role> roleList) {
        this.userName = userName;
        this.password = password;
        this.roleList = roleList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }
}
