package org.kuznetsov.sd7.supermarket.model.pojo;

public class Client {
    private long idClient;
    private String name;
    private String surname;
    private String patronymic;
    private String phone;
    private String login;
    private String password;
    private String role;
    private String email;

    public Client() {
    }

    public Client(long idClient, String name, String surname, String patronymic, String phone, String login, String password, String role, String email) {
        this(name, surname, patronymic, phone, login, password, role, email);
        this.idClient = idClient;
    }

    public Client(String name, String surname, String patronymic, String phone, String login, String password, String role, String email) {
        this(name, surname, phone, login, password, role, email);
        this.patronymic = patronymic;
    }

    public Client(String name, String surname, String phone, String login, String password, String role, String email) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.login = login;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    public long getidClient() {
        return idClient;
    }

    public void setidClient(long idClient) {
        this.idClient = idClient;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", phone='" + phone + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
