package org.kuznetsov.sd7.supermarket.validator;

import org.kuznetsov.sd7.supermarket.model.pojo.OrderType;
import org.kuznetsov.sd7.supermarket.service.OrderTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator {

    private OrderTypeService orderTypeService;

    @Autowired
    public void setOrderTypeService(OrderTypeService orderTypeService) {
        this.orderTypeService = orderTypeService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return OrderType.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        OrderType orderType = (OrderType) o;

        if(orderTypeService.findProductByName(orderType.getOrderType()) != null) {
            errors.rejectValue("orderType", "Engaged.productForm.orderType");
        }
    }
}
