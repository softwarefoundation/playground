package com.softwarefoundation.playground;

import java.math.BigDecimal;

public class DiferencaDoQuadradoDaSomaEaSomaDoQuadrado100NumerosIssue7 {

    public static void main(String[] args) {
        BigDecimal quadrado = BigDecimal.ZERO;
        BigDecimal soma = BigDecimal.ZERO;

        for (int i = 1; i <= 100; i++) {
           quadrado = quadrado.add(BigDecimal.valueOf(Math.pow(i,2)));
           soma = soma.add(BigDecimal.valueOf(i));
        }
        soma = soma.pow(2);

        BigDecimal resultado = soma.subtract(quadrado);

        System.out.println(quadrado);
        System.out.println(soma);
        System.out.println(resultado.toString());

    }

}
