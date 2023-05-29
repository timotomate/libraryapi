package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import org.springframework.web.bind.annotation.*;

@RestController // API의 진입지점으로 만들겠다.
public class CalculatorController {

    @GetMapping("/add")
    public int addTwoNumbers(CalculatorAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }

//    public int addTwoNumbers(
//            @RequestParam int number1,
//            @RequestParam int number2
//    ) {
//        return number1 + number2;
//    }

    @PostMapping("/multiply")
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest request) {
        System.out.println("Result is ");
        return request.getNumber1() * request.getNumber2();
    }

    @GetMapping("/add/rp")
    public int addTwoNumbersByRequestParam(@RequestParam int number1, @RequestParam int number2) {
        return number1 + number2;
    }
}