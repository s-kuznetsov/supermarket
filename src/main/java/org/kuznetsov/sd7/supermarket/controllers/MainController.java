package org.kuznetsov.sd7.supermarket.controllers;

import org.kuznetsov.sd7.supermarket.controllers.pojo.RegistrationUser;
import org.kuznetsov.sd7.supermarket.model.pojo.Client;
import org.kuznetsov.sd7.supermarket.model.pojo.OrderType;
import org.kuznetsov.sd7.supermarket.service.*;
import org.kuznetsov.sd7.supermarket.validator.RegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    private OrderTypeService orderTypeService;
    private ClientService clientService;
    private RegistrationValidator registrationValidator;

    @Autowired
    public void setOrderTypeService(OrderTypeService orderTypeService) {
        this.orderTypeService = orderTypeService;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    public void setRegistrationValidator(RegistrationValidator registrationValidator) {
        this.registrationValidator = registrationValidator;
    }

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        List<OrderType> allProducts = orderTypeService.getAllProducts();
        model.addAttribute("products", allProducts);
        return "welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String submitLogin(Model model, String error, String logout) {

        if (error != null) {
            model.addAttribute("error", "Данная учетная запись не существует!");
        }

        if (logout != null) {
            model.addAttribute("message", "Выход совершён успешно!");
        }

        return "login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String showRegistrationPage(Model model) {
        model.addAttribute("registrationForm", new RegistrationUser());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String submitRegistration(@ModelAttribute("registrationForm") @Valid RegistrationUser registrationUser, BindingResult bindingResult, Model model) {

        registrationValidator.validate(registrationUser, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        Client client = createNewClient(registrationUser);
        clientService.addClient(client);
        return "redirect:/user/" + client.getLogin() + "/main-page";
    }

    private Client createNewClient(RegistrationUser registrationUser) {
        return new Client(registrationUser.getName(), registrationUser.getSurname(), registrationUser.getPatronymic(),
                registrationUser.getPhone(), registrationUser.getLogin(), registrationUser.getPasswordOne(), "ROLE_USER", registrationUser.getEmail());
    }
}
