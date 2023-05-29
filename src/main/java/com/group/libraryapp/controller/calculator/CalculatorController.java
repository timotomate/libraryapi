package com.group.libraryapp.controller.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // API의 진입지점으로 만들겠다.
public class CalculatorController {

    @GetMapping("/add")
    public int addTwoNumbers(
            @RequestParam int number1,
            @RequestParam int number2
    ) {
        return number1 + number2;
    }
}