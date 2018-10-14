package org.kuznetsov.sd7.supermarket.validator;

import org.kuznetsov.sd7.supermarket.controllers.pojo.RegistrationUser;
import org.kuznetsov.sd7.supermarket.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class RegistrationValidator implements Validator {

    private ClientService clientService;

    @Autowired
    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return RegistrationUser.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RegistrationUser registrationUser = (RegistrationUser) o;

        if (clientService.findByLogin(registrationUser.getLogin()) != null) {
            errors.rejectValue("login", "Engaged.registrationForm.login");
        }

        if (!registrationUser.getPasswordOne().equals(registrationUser.getPasswordTwo())) {
            errors.rejectValue("passwordOne", "Notmatch.registrationForm.passwordOne");
        }

        if (clientService.findByNumberPhone(registrationUser.getPhone()) != null) {
            errors.rejectValue("phone", "Engaged.registrationForm.phone");
        }

        if (clientService.findByEmail(registrationUser.getEmail()) != null) {
            errors.rejectValue("email", "Engaged.registrationForm.email");
        }
    }
}
