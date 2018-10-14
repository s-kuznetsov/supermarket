package org.kuznetsov.sd7.supermarket.controllers;

import org.kuznetsov.sd7.supermarket.model.pojo.Client;
import org.kuznetsov.sd7.supermarket.model.pojo.Order;
import org.kuznetsov.sd7.supermarket.model.pojo.OrderType;
import org.kuznetsov.sd7.supermarket.service.ClientService;
import org.kuznetsov.sd7.supermarket.service.OrderService;
import org.kuznetsov.sd7.supermarket.service.OrderTypeService;
import org.kuznetsov.sd7.supermarket.validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/page-admin")
public class AdminController {

    private OrderTypeService orderTypeService;
    private ClientService clientService;
    private OrderService orderService;
    private ProductValidator productValidator;

    @Autowired
    public void setOrderTypeService(OrderTypeService orderTypeService) {
        this.orderTypeService = orderTypeService;
    }

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setProductValidator(ProductValidator productValidator) {
        this.productValidator = productValidator;
    }

    @RequestMapping(value = "/products")
    public String showAdminPanel(Model model) {
        List<OrderType> allProducts = orderTypeService.getAllProducts();
        model.addAttribute("value", "Администратор");
        model.addAttribute("products", allProducts);
        return "page-admin";
    }

    @RequestMapping(value = "/all-clients")
    public String showAllClients(Model model) {
        List<Client> clients = clientService.getAllClients();
        model.addAttribute("value", "Администратор");
        model.addAttribute("clients", clients);
        return "all-clients";
    }

    @RequestMapping(value = "/all-orders")
    public String showAllOrders(Model model) {
        List<Order> orders = orderService.getAllOrders();
        model.addAttribute("value", "Администратор");
        model.addAttribute("orders", orders);
        return "all-orders";
    }

    @RequestMapping(value = "/add-product")
    public String addProduct(Model model) {
        model.addAttribute("productForm", new OrderType());
        return "add-product";
    }

    @RequestMapping(value = "/add-product", method = RequestMethod.POST)
    public String submitAddProduct(@ModelAttribute("productForm") @Valid OrderType orderType, BindingResult bindingResult, Model model) {

        productValidator.validate(orderType, bindingResult);

        if (bindingResult.hasErrors()) {
            return "add-product";
        }

        orderTypeService.addProduct(orderType);
        return "redirect:/page-admin/products";
    }

    @RequestMapping(value = "/{idOrderType}/edit-product")
    public String editProduct(@PathVariable String idOrderType, Model model) {
        long idProduct = Long.parseLong(idOrderType);
        model.addAttribute("productForm", orderTypeService.getOrderTypeById(idProduct));
        return "edit-product";
    }

    @RequestMapping(value = "/{idOrderType}/edit-product", method = RequestMethod.POST)
    public String submitEditProduct(@ModelAttribute("productForm") @Valid OrderType orderType, BindingResult bindingResult, Model model) {

        productValidator.validate(orderType, bindingResult);

        if (bindingResult.hasErrors()) {
            return "edit-product";
        }

        orderTypeService.editProduct(orderType);
        return "redirect:/page-admin/products";
    }
}
