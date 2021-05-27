package com.softwarefoundation.playground;


import java.text.MessageFormat;
import java.util.function.Function;

/**
 *Um número palíndromo tem a mesma leitura nos dois sentidos. O maior palíndromo feito do produto de dois números de 2 dígitos é 9009 = 91 × 99.
 *
 * Encontre o maior palíndromo feito do produto de dois números de 3 dígitos.
 * @apiNote https://projecteuler.net/problem=4
 */
public class MaiorPalindromoDoProdutoDeTresDigitosIssue5 {

    public static void main(String[] args) {


        Function<Integer,Boolean> isPalindromo = numero -> {
            String palindromo = new StringBuilder(numero.toString()).reverse().toString();
            return  numero.toString().equals(palindromo);
        };

       Integer maiorPalidromo = 0;

       for(int x = 100; x <= 999; x++){
           for(int y = 100; y <= 999; y++){
               Integer numero = x * y;
               if(isPalindromo.apply(numero)){
                   maiorPalidromo = Math.max(maiorPalidromo, numero);
               }
           }
       }

        System.out.println(MessageFormat.format("Palindromo: {0}", maiorPalidromo));

    }


}
