package com.softwarefoundation.playground;

import java.text.MessageFormat;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
    Cada novo termo na sequência de Fibonacci é gerado adicionando os dois termos anteriores.
    Começando com 1 e 2, os primeiros 10 termos serão:

    1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

    Ao considerar os termos na sequência de Fibonacci cujos valores não excedem quatro milhões,
    encontre a soma dos termos de valor par.
    @apiNote  https://projecteuler.net/problem=2
 */
public class SomarTermosParesDaSerioFibonacciIssue2 {

    public static void main(String[] args) {
        Integer primeiroTermo = 1;
        Integer segundoTermo = 2;
        Integer proximoTermo =  0;
        Integer total = segundoTermo;
        BiFunction<Integer,Integer,Integer> calcularProximoTermo = (pTermo , sTermo) -> pTermo + sTermo;
        BiFunction<Integer, Function<Integer, Boolean>, Integer> calcularNumeroPar = (numero, functionIsPar) -> functionIsPar.apply(numero) ? numero : 0;

        while (segundoTermo <= 4000000){
            proximoTermo = calcularProximoTermo.apply(primeiroTermo,segundoTermo);
            primeiroTermo = segundoTermo;
            segundoTermo = proximoTermo;
            total += calcularNumeroPar.apply(proximoTermo, (numero) -> numero % 2 == 0);
        }
        System.out.println(MessageFormat.format("Total: {0}", total));

    }

}
