package org.kuznetsov.sd7.supermarket.controllers.pojo;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class RegistrationUser {

    @Size(min = 3)
    private String login;

    @Size(min = 8)
    private String passwordOne;

    private String passwordTwo;

    @Size(min = 1)
    private String name;

    @Size(min = 1)
    private String surname;

    private String patronymic;

    @Size(min = 1)
    @Pattern(regexp="(^$|[0-9]{11})")
    private String phone;

    @Size(min = 1)
    @Email
    private String email;

    public RegistrationUser() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPasswordOne() {
        return passwordOne;
    }

    public void setPasswordOne(String passwordOne) {
        this.passwordOne = passwordOne;
    }

    public String getPasswordTwo() {
        return passwordTwo;
    }

    public void setPasswordTwo(String passwordTwo) {
        this.passwordTwo = passwordTwo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
