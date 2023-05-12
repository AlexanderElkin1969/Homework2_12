package pro.sky.java.course2.newCalculator.service;

import org.springframework.stereotype.Service;

@Service
public class NewCalculatorServiceImpl implements NewCalculatorService {
    double result;
    int parsedNum1;
    int parsedNum2;
    String str;
    public String calculate(int operation , String num1, String  num2){
        if (num1.equals("")||num2.equals("")) {return " Ошибка ввода данных ";}
        parsedNum1 = Integer.parseInt(num1);
        parsedNum2 = Integer.parseInt(num2);
        switch (operation){
            case 1 :
                result = parsedNum1 + parsedNum2;
                str = " + ";
                break;
            case 2 :
                result = parsedNum1 - parsedNum2;
                str = " - ";
                break;
            case 3 :
                result = parsedNum1 * parsedNum2;
                str = " * ";
                break;
            case 4 :
                if (parsedNum2==0) {return " Ошибка ввода данных: Делить на 0 нельзя !!!";}
                result = (double) parsedNum1 / parsedNum2;
                str = " / ";
                break;
        }
        return num1 + str + num2 + " = " + result;
    }
}
