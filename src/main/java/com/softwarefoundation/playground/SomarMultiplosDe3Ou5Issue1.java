package com.softwarefoundation.playground;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Se listarmos todos os números naturais abaixo de 10 que são múltiplos de 3 ou 5, obteremos 3, 5, 6 e 9.
 * A soma desses múltiplos é 23.
 * Encontre a soma de todos os múltiplos de 3 ou 5 abaixo de 1000.
 */
public class SomarMultiplosDe3Ou5Issue1 {

    private static Integer QUANTIDADE_NUMEROS = 1000;

    public static void main(String[] args) {

        BiFunction<Integer,Integer, Boolean> isXMultiploDeY = (x,y)-> x % y == 0;

        Predicate<Integer> isMultiploDe3Ou5 = (numero) -> isXMultiploDeY.apply(numero, 3) || isXMultiploDeY.apply(numero,5);

        List<Integer> numerosNaturais = new ArrayList<>();

        for(int i = 0; i < QUANTIDADE_NUMEROS; i++){
            numerosNaturais.add(i);
        }

        Integer resultado = numerosNaturais.stream().filter(isMultiploDe3Ou5).mapToInt(Integer::intValue).sum();
        System.out.println(MessageFormat.format("Resultado: {0}", resultado));

    }

}
