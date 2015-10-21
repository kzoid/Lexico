package br.rigel.mack.automatos;

import br.rigel.mack.automatos.lexico.States;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by ricardo.gelschleiter on 21/10/2015.
 */
public class Main {
    static private LinkedHashMap<States, Map<Character, States>> tabelaSimbolos = new LinkedHashMap<>();

    static {
        // adiciona todos os estados
        for (States state : States.values()) {
            tabelaSimbolos.put(state, null);
        }

        // adiciona as transicoes
        Map<Character, States> trans;

        // de q0
        trans = new HashMap<>();
        trans.put('b', States.Q14);
        trans.put('c', States.Q13);
        trans.put('d', States.Q17);
        trans.put('e', States.Q5);
        trans.put('i', States.Q8);
        trans.put('l', States.Q7);
        trans.put('t', States.Q1);
        trans.put('v', States.Q22);
        trans.put('w', States.Q15);
        trans.put(':', States.DOISPONTOS);
        trans.put('=', States.IGUAL);
        trans.put('(', States.APAR);
        trans.put(')', States.FPAR);
        trans.put('+', States.MAIS);
        trans.put('-', States.MENOS);
        trans.put('*', States.VEZES);
        trans.put('/', States.DIVIDIR);
        trans.put('<', States.MENOR);
        trans.put('>', States.MAIOR);
        trans.put(';', States.PONTOVIRGULA);
        trans.put('~', States.TIO);
        trans.put('!', States.EXCLAMACAO);

        tabelaSimbolos.put(States.Q0, trans);

        // q17
        trans = new HashMap<>();
        trans.put('o', States.DO);

        tabelaSimbolos.put(States.Q17, trans);

        // q5
        trans = new HashMap<>();
        trans.put('l', States.Q25);
        trans.put('n', States.Q24);

        tabelaSimbolos.put(States.Q5, trans);

        // q22
        trans = new HashMap<>();
        trans.put('a', States.Q34);

        tabelaSimbolos.put(States.Q22, trans);

        // q24
        trans = new HashMap<>();
        trans.put('d', States.END);

        tabelaSimbolos.put(States.Q24, trans);

        // q25
        trans = new HashMap<>();
        trans.put('s', States.Q37);

        tabelaSimbolos.put(States.Q25, trans);

        // q37
        trans = new HashMap<>();
        trans.put('e', States.ELSE);

        tabelaSimbolos.put(States.Q37, trans);

        // q34
        trans = new HashMap<>();
        trans.put('r', States.VAR);

        tabelaSimbolos.put(States.Q34, trans);

        // q13
        trans = new HashMap<>();
        trans.put('o', States.Q30);

        tabelaSimbolos.put(States.Q13, trans);

        // q30
        trans = new HashMap<>();
        trans.put('n', States.Q39);

        tabelaSimbolos.put(States.Q30, trans);

        // q39
        trans = new HashMap<>();
        trans.put('s', States.Q45);

        tabelaSimbolos.put(States.Q39, trans);

        // q45
        trans = new HashMap<>();
        trans.put('t', States.CONST);

        tabelaSimbolos.put(States.Q45, trans);

        // q7
        trans = new HashMap<>();
        trans.put('e', States.Q26);

        tabelaSimbolos.put(States.Q7, trans);

        // q26
        trans = new HashMap<>();
        trans.put('t', States.LET);

        tabelaSimbolos.put(States.Q26, trans);

        // q8
        trans = new HashMap<>();
        trans.put('f', States.IF);
        trans.put('n', States.IN);

        tabelaSimbolos.put(States.Q8, trans);

        // q1
        trans = new HashMap<>();
        trans.put('h', States.Q23);

        tabelaSimbolos.put(States.Q1, trans);

        // q23
        trans = new HashMap<>();
        trans.put('e', States.Q35);

        tabelaSimbolos.put(States.Q23, trans);

        // q35
        trans = new HashMap<>();
        trans.put('n', States.THEN);

        tabelaSimbolos.put(States.Q35, trans);

        // q15
        trans = new HashMap<>();
        trans.put('h', States.Q32);

        tabelaSimbolos.put(States.Q15, trans);

        // q32
        trans = new HashMap<>();
        trans.put('i', States.Q41);

        tabelaSimbolos.put(States.Q32, trans);

        // q41
        trans = new HashMap<>();
        trans.put('l', States.Q47);

        tabelaSimbolos.put(States.Q41, trans);

        // q47
        trans = new HashMap<>();
        trans.put('e', States.WHILE);

        tabelaSimbolos.put(States.Q47, trans);

        // q14
        trans = new HashMap<>();
        trans.put('e', States.Q31);

        tabelaSimbolos.put(States.Q14, trans);

        // q31
        trans = new HashMap<>();
        trans.put('g', States.Q40);

        tabelaSimbolos.put(States.Q31, trans);

        // q40
        trans = new HashMap<>();
        trans.put('i', States.Q46);

        tabelaSimbolos.put(States.Q40, trans);

        // q46
        trans = new HashMap<>();
        trans.put('n', States.BEGIN);

        tabelaSimbolos.put(States.Q46, trans);
    }

    public static void main(String[] args) {
        States currState = States.Q0;

        String numeros_naturais = "[0-9]+";
        String identificadores = "[a-zA-Z][a-zA-Z0-9]*";

        // TODO: ler a partir de arquivo
        String entrada = (args[0] != null) ? args[0] : "if ( v1 ) else if ( v2 ) then ;";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < entrada.toCharArray().length + 1; i++) {
            // no estado atual, pra onde posso ir
            Map<Character, States> transicoes = tabelaSimbolos.get(currState);
            if (transicoes == null) { // nao existem transicoes no estado atual
                if (currState.isFinal()) { // eh um estado final?
                    String token;
                    if (currState.equals(currState.IDENTIFICADOR) || currState.equals(currState.NUMERAL))
                        token = sb.toString();
                    else
                        token = currState.getToken();
                    System.out.println("Encontrou: " + token + "\t\t| " + currState);
                } else { // zica
                    System.out.println("Entrada invalida: " + sb.toString() + " ERROR");
                }

                sb = new StringBuilder();
                currState = States.Q0;
                continue;
            }

            try {
                // se ler espaco, ignora
                if (' ' == entrada.charAt(i)) continue;

                //guarda a sequencia lida
                sb.append(entrada.charAt(i));

                States nextState = transicoes.get(entrada.charAt(i));
                if (nextState != null) {
                    currState = nextState;
                    //System.out.println("Leu " + entrada.charAt(i) + " > " + nextState);
                } else {
                    //System.out.println("Leu " + entrada.charAt(i) + " > " + nextState);
                    if (sb.toString().matches(numeros_naturais)) {
                        currState = States.NUMERAL;
                    } else if (sb.toString().matches(identificadores)) {
                        currState = States.IDENTIFICADOR;
                    } else {
                        currState = States.ERRO;
                    }
                }

            } catch (IndexOutOfBoundsException e) {
                continue;
            }
        }
    }
}
