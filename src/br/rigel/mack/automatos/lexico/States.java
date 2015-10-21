package br.rigel.mack.automatos.lexico;

/**
 * Created by ricardo.gelschleiter on 21/10/2015.
 */
public enum States {

    Q0 ("q0", Boolean.FALSE),
    Q17 ("q17", Boolean.FALSE),
    Q5 ("q5", Boolean.FALSE),
    Q22 ("q22", Boolean.FALSE),
    DO ("do", Boolean.TRUE),
    Q24 ("q24", Boolean.FALSE),
    END ("end", Boolean.TRUE),
    Q25 ("q25", Boolean.FALSE),
    Q37 ("q37", Boolean.FALSE),
    ELSE ("else", Boolean.TRUE),
    APAR ("(", Boolean.TRUE),
    FPAR (")", Boolean.TRUE),
    Q34 ("q34", Boolean.FALSE),
    VAR ("var", Boolean.TRUE),
    Q13 ("q13", Boolean.FALSE),
    Q30 ("q30", Boolean.FALSE),
    Q39 ("q39", Boolean.FALSE),
    Q45 ("q45", Boolean.FALSE),
    CONST ("const", Boolean.TRUE),
    Q7 ("q7", Boolean.FALSE),
    Q26 ("q26", Boolean.FALSE),
    LET ("let", Boolean.TRUE),
    Q8 ("q8", Boolean.FALSE),
    IN ("in", Boolean.TRUE),
    IF ("if", Boolean.TRUE),
    DOISPONTOS (":", Boolean.TRUE),
    DOISPONTOSIGUAL (":=", Boolean.TRUE),
    MAIOR (">", Boolean.TRUE),
    MENOR ("<", Boolean.TRUE),
    MENOS ("-", Boolean.TRUE),
    MAIS ("+", Boolean.TRUE),
    Q1 ("q1", Boolean.FALSE),
    Q23 ("q23", Boolean.FALSE),
    Q35 ("q35", Boolean.FALSE),
    THEN ("then", Boolean.TRUE),
    VEZES ("*", Boolean.TRUE),
    IGUAL ("=", Boolean.TRUE),
    Q15 ("q15", Boolean.FALSE),
    Q32 ("q32", Boolean.FALSE),
    Q41 ("q41", Boolean.FALSE),
    Q47 ("q47", Boolean.FALSE),
    WHILE ("while", Boolean.TRUE),
    DIVIDIR ("/", Boolean.TRUE),
    Q14 ("q14", Boolean.FALSE),
    Q31 ("q31", Boolean.FALSE),
    Q40 ("q40", Boolean.FALSE),
    Q46 ("q46", Boolean.FALSE),
    BEGIN ("begin", Boolean.TRUE),
    TIO ("~", Boolean.TRUE),
    PONTOVIRGULA (";", Boolean.TRUE),
    EXCLAMACAO ("!", Boolean.TRUE),
    NUMERAL ("[0..9]+", Boolean.TRUE),
    IDENTIFICADOR ("[a-zA-Z][a-zA-Z0-9]*", Boolean.TRUE),
    ERRO ("erro", Boolean.FALSE);

    private final String token;
    private final boolean fim;

    States(String token, boolean fim) {
        this.token = token;
        this.fim = fim;
    }

    public String getToken() { return token; }
    public boolean isFinal() { return fim; }
}
