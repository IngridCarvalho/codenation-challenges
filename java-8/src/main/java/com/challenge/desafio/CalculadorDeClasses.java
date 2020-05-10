package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object obj) {
        return sumFields(obj, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object obj) {
        return sumFields(obj, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object obj) {
        return somar(obj).subtract(subtrair(obj));
    }

    private BigDecimal sumFields(Object obj, Class annotation) {
        Field[] fields = obj.getClass().getDeclaredFields();
        BigDecimal sum = BigDecimal.ZERO;

        for (Field field: fields) {
            if(field.isAnnotationPresent(annotation) && field.getType().equals(BigDecimal.class)) {
                try {
                    field.setAccessible(true);
                    BigDecimal value = (BigDecimal) field.get(obj);

                    sum = sum.add(value);

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return sum;
    }
}
