package pro.sky.java.course2.newCalculator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pro.sky.java.course2.newCalculator.exception.MyIllegalArgumentException;
import pro.sky.java.course2.newCalculator.service.*;

@RestController
@RequestMapping("/calculator")
    public class NewCalculatorController {
    private final NewCalculatorService newCalculatorService;

    public NewCalculatorController(NewCalculatorService newCalculatorService){
        this.newCalculatorService = newCalculatorService;
    }
    @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
    public String hello(){
        return "<h1 style = \" color: red \">Добро пожаловать в калькулятор</h1>";
    }
    @GetMapping(path="/plus")
    public String plus(@RequestParam("num1") String num1, @RequestParam("num2") String num2){
        return newCalculatorService.calculate(1, num1, num2);
    }
    @GetMapping(path="/minus")
    public String minus(@RequestParam("num1") String num1, @RequestParam("num2") String num2){
        return newCalculatorService.calculate(2, num1, num2);
    }
    @GetMapping(path="/multiply")
    public String multiply(@RequestParam("num1") String num1, @RequestParam("num2") String num2){
        return newCalculatorService.calculate(3, num1, num2);
    }
    @GetMapping(path="/divide")
    public String divide(@RequestParam("num1") String num1, @RequestParam("num2") String num2){
        return newCalculatorService.calculate(4, num1, num2);
    }

    @ExceptionHandler(MyIllegalArgumentException.class)
    public String MyIllegalArgumentException(MyIllegalArgumentException e) {
        return e.getMessage();
    }
}
