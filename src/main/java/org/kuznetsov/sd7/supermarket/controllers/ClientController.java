package org.kuznetsov.sd7.supermarket.controllers;

import org.kuznetsov.sd7.supermarket.model.pojo.Client;
import org.kuznetsov.sd7.supermarket.model.pojo.Order;
import org.kuznetsov.sd7.supermarket.model.pojo.OrderType;
import org.kuznetsov.sd7.supermarket.service.ClientService;
import org.kuznetsov.sd7.supermarket.service.OrderService;
import org.kuznetsov.sd7.supermarket.service.OrderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/user/{login}")
public class ClientController {

    private OrderTypeService orderTypeService;
    private ClientService clientService;
    private OrderService orderService;

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

    @PreAuthorize("#login == principal.username")
    @RequestMapping(value = "/main-page")
    public String showMainPanel(@PathVariable String login, Model model) {
        Client client = clientService.findByLogin(login);
        List<OrderType> allProducts = orderTypeService.getAllProducts();
        model.addAttribute("login", login);
        model.addAttribute("value", client.getSurname() + " " + client.getName());
        model.addAttribute("products", allProducts);
        return "page-client";
    }

    @PreAuthorize("#login == principal.username")
    @RequestMapping(value = "/delete-order/{idOrder}", method = RequestMethod.POST)
    public String deleteMyOrder(@PathVariable("idOrder") String idOrder, @PathVariable("login") String login, Model model) {
        Long id = Long.valueOf(idOrder);
        orderService.deleteOrderById(id);
        return "redirect:/user/" + login + "/orders";
    }

    @PreAuthorize("#login == principal.username")
    @RequestMapping(value = "/orders")
    public String showMyOrders(@PathVariable String login, Model model) {
        Client client = clientService.findByLogin(login);
        if(client != null) {
            List<Order> ordersOfClient = orderService.getOrdersOfClient(client);
            model.addAttribute("login", login);
            model.addAttribute("value", client.getSurname() + " " + client.getName());
            model.addAttribute("orders", ordersOfClient);
        }
        return "orders";
    }

    @PreAuthorize("#login == principal.username")
    @RequestMapping(value = "/buy-product/{idOrderType}", method = RequestMethod.POST)
    public String buyProduct(@PathVariable("login") String login, @PathVariable("idOrderType") String idOrderType, Model model) {
        OrderType product = orderTypeService.getOrderTypeById(Long.parseLong(idOrderType));
        Client client = clientService.findByLogin(login);

        orderService.addOrder(new Order(client.getidClient(), new Date(), product.getCost() , "PLANNED", product.getOrderType()));
        return "redirect:/user/" + login + "/orders";
    }
}
