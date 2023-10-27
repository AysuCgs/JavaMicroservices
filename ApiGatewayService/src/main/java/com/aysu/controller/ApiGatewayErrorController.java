package com.aysu.controller;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApiGatewayErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping(value = ERROR_PATH, method = RequestMethod.GET)
    public String handleError() {
        // Bu kısımda 404.html sayfasına yönlendirme işlemi gerçekleştirilir.
        return "redirect:/404.html";
    }
}






