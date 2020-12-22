package com.renho.springcloud.demo.service.noregistry.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author renho
 * @date 2020/12/22
 */
@RestController
@RequestMapping("/renho")
public class RenhoController {

    @GetMapping
    public String test() {
        return "noregistry.RenhoController.test";
    }

}
