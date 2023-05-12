package pro.sky.java.course2.newCalculator.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.java.course2.newCalculator.exception.MyIllegalArgumentException;

@Service
public class NewCalculatorServiceImpl implements NewCalculatorService {
    double result;
    int parsedNum1;
    int parsedNum2;
    String str;
    public String calculate(int operation , String num1, String  num2){
     //   if (num1.equals("")||num2.equals("")) {return " Ошибка ввода данных ";}
        if (StringUtils.isNumeric(num1)&&StringUtils.isNumeric(num2)) {
            parsedNum1 = Integer.parseInt(num1);
            parsedNum2 = Integer.parseInt(num2);
        }else {
            throw new MyIllegalArgumentException("Ошибка ввода данных. Введите числа.");
        }
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
                if (parsedNum2==0) {
                    throw new MyIllegalArgumentException("Ошибка ввода данных: Делить на 0 нельзя !!!");
                }
                result = (double) parsedNum1 / parsedNum2;
                str = " / ";
                break;
        }
        return num1 + str + num2 + " = " + result;
    }
}
