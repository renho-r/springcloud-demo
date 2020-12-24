package com.renho.springcloud.demo.service.noregistry.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author renho
 * @date 2020/12/22
 */
@RestController
@RequestMapping("/anything")
public class RenhoController {

    @GetMapping("/{any}")
    public String test(@PathVariable String any) {
        return "noregistry.RenhoController.test( /anything/" + any + " )";
    }

}
