package com.softwarefoundation.playground;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * https://projecteuler.net/problem=11
 */
public class MaiorProdutoDe4NumerosAdjacentesIssue9 {

    public static void main(String[] args) throws IOException {

        MaiorProdutoDe4NumerosAdjacentesIssue9 issue9 = new MaiorProdutoDe4NumerosAdjacentesIssue9();
        issue9.executar();
    }

    void executar() throws IOException {

        List<String> registros = Files.readAllLines(Paths.get("src/main/resources/issue9.txt"));
        List<List<Integer>> matrix = new ArrayList<>();

        registros.forEach(registro -> {
            matrix.add(Arrays.asList(registro.split(" ")).stream().map(s -> Integer.valueOf(s)).collect(Collectors.toList()));
        });

        Stack<Integer> resultados = new Stack<>();

        List<CalculoIssue9> algoritmos = new ArrayList<>();
        algoritmos.add( new CalculoVerticalIssue9());
        algoritmos.add( new CalculoHorizontalIssue9());
        algoritmos.add( new CalculoDiagonalDireitaIssue9());
        algoritmos.add( new CalculoDiagonalEsquerdaIssue9());

        algoritmos.forEach( algoritimo -> resultados.add( buscar(algoritimo,matrix) ));

        Collections.sort(resultados);

        System.out.println(MessageFormat.format("Maior resultado: {0}", resultados.lastElement()));

        System.out.println(resultados.toString());
        Collections.reverse(resultados);
        System.out.println(resultados.toString());

    }

    Integer buscar(CalculoIssue9 algoritimo, List<List<Integer>> matrix){
        Integer total = 0;
        for (int linha = 0; linha < matrix.size(); linha++) {
            for (int coluna = 0; coluna < (matrix.get(linha).size()); coluna++) {
                Integer resultado = algoritimo.calculo(matrix, linha, coluna);
                total = Math.max(total, resultado);
            }
        }
        return total;
    }

}

interface CalculoIssue9 {
    Integer calculo(List<List<Integer>> matrix, Integer linha, Integer coluna);
}

class CalculoVerticalIssue9 implements CalculoIssue9 {
    @Override
    public Integer calculo(List<List<Integer>> matrix, Integer linha, Integer coluna) {
        int total = 1;
        int fim = linha + 4;
        try {
            for (; linha < fim; linha++) {
                Integer elemento = matrix.get(linha).get(coluna);
                total *= elemento;
            }
        } catch (Exception e) {}
        return total;
    }
}

class CalculoHorizontalIssue9 implements CalculoIssue9 {
    @Override
    public Integer calculo(List<List<Integer>> matrix, Integer linha, Integer coluna) {
        int total = 1;
        int fim = coluna + 4;
        try {
            for (; coluna < fim; coluna++) {
                Integer elemento = matrix.get(linha).get(coluna);
                total *= elemento;
            }
        } catch (Exception e) {}
        return total;
    }
}

class CalculoDiagonalDireitaIssue9 implements CalculoIssue9 {
    @Override
    public Integer calculo(List<List<Integer>> matrix, Integer linha, Integer coluna) {
        int total = 1;
        int fim = linha + 4;
        try {
            for (; linha < fim; linha++) {
                Integer elemento = matrix.get(linha).get(coluna++);
                total *= elemento;
            }
        } catch (Exception e) {}
        return total;
    }
}

class CalculoDiagonalEsquerdaIssue9 implements CalculoIssue9 {
    @Override
    public Integer calculo(List<List<Integer>> matrix, Integer linha, Integer coluna) {
        int total = 1;
        int fim = linha + 4;
        try {
            for (; linha < fim; linha++) {
                Integer elemento = matrix.get(linha).get(coluna--);
                total *= elemento;
            }
        } catch (Exception e) {}
        return total;
    }
}
