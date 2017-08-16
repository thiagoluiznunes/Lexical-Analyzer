/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexical.analizer;

import java.util.ArrayList;

/**
 *
 * @author thiago
 */
public class Tokens {
    
    protected String[] keyWords = {"program", "var", "integer", "real", "boolean", "procedure", "begin",
                                "end", "if", "then", "else", "while", "do", "not"};
    
    protected String identifiers = "([a-z]|[A-Z])([0-9]|[a-z]+|[A-Z]|_)*";
    protected String[] delimiters = {";",".",":","(",")",","};
    protected String attributtion = ":=";
    protected String[] operatiorsR = {"=","<",">","<=",">=","<>"};
    protected String[] operatiorsA = {"+","-","or"};
    protected String[] operatiorsM = {"*","/","and"};
    
    protected String intDigits = "[0-9]+";
    protected String floatDigits = "[0-9]+[.][0-9]+";
    protected String[] booleanDigits = {"true", "false"};
    
    protected ArrayList<String> myProgram = null;

    public Tokens(ArrayList<String> myArrayList) {
        this.myProgram = myArrayList;
    }
    
    public void lexicAnalizer() {
        
        for(int i = 0; i < this.myProgram.size(); i++) {
        }
    }
           
}
