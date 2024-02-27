package com.pf;

import com.pf.enums.AmountTypeEnum;
import com.pf.service.IncomeExpenseService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonalFinanceManagerApplicationTests {

    @Test
    void contextLoads() {
    }

    public static void main(String args[]) {
        byte minB = -128;
        byte maxB = 127;
        System.out.println("minB: " + minB);
        System.out.println("maxB: " + maxB);

        short minS = -32768;
        short maxS = 32767;
        System.out.println("minS: " + minS);
        System.out.println("maxS: " + maxS);

        char c = 'a';
        System.out.println("char: " + c);

        int minI = -2147483648;
        int maxI = 2147483647;
        System.out.println("minI: " + minI);
        System.out.println("maxI: " + maxI);

        long minL = -9223372036854775808L;
        long maxL = 9223372036854775807L;
        long maxL2 = (long) 932E10;
        System.out.println("minL: " + minL);
        System.out.println("maxL: " + maxL);
        System.out.println("maxL2: " + maxL2);

        float minF = -3.4028235E38F;
        float maxF = 3.4028235E38F;
        System.out.println("minF: " + minF);
        System.out.println("maxF: " + maxF);

        double d = 123456789123456789.98;
        System.out.println("double : " + d);

        System.out.println(formatterPatternSwitch("asd"));

        System.out.println(AmountTypeEnum.I.getText());
        System.out.println(AmountTypeEnum.fromName("I").getText());
        System.out.println(AmountTypeEnum.fromText("Income").getText());
        System.out.println(AmountTypeEnum.getName("E"));
        System.out.println(AmountTypeEnum.getText("E"));
    }

    static String formatterPatternSwitch(Object obj) {
        return switch (obj) {
            case Integer i -> String.format("int %d", i);
            case Long l -> String.format("long %d", l);
            case Double d -> String.format("double %f", d);
            case String s -> String.format("String %s", s);
            default -> obj.toString();
        };

            /*switch (obj) {
                case String s when s.length() > 5 -> System.out.println(s.toUpperCase());
                case String s                     -> System.out.println(s.toLowerCase());
                case Integer i                    -> System.out.println(i * i);
                default                           -> {}
            }*/
    }

    static String formatter(Object obj) {
        String formatted = "unknown";
        if (obj instanceof Integer i) {
            formatted = String.format("int %d", i);
        } else if (obj instanceof Long l) {
            formatted = String.format("long %d", l);
        } else if (obj instanceof Double d) {
            formatted = String.format("double %f", d);
        } else if (obj instanceof String s) {
            formatted = String.format("String %s", s);
        }
        return formatted;
    }
}
