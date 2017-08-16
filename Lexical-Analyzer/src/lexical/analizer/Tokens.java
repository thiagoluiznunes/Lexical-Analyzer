
package lexical.analizer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Thiago Luiz Nunes
 */
public class Tokens {
    
    protected ArrayList<String> keyWords = new ArrayList<>(Arrays.asList("program", "var", "integer", "real", "boolean", "procedure", "begin",
                    "end", "if", "then", "else", "while", "do", "not"));
    
    protected ArrayList<String> delimiters = new ArrayList<>(Arrays.asList(";",".",":","(",")",","));
    protected ArrayList<String> operatiorsR = new ArrayList<>(Arrays.asList("=","<",">","<=",">=","<>"));
    protected ArrayList<String> operatiorsA = new ArrayList<>(Arrays.asList("+","-","or"));
    protected ArrayList<String> operatiorsM = new ArrayList<>(Arrays.asList("*","/","and"));
    protected ArrayList<String> booleanDigits = new ArrayList<>(Arrays.asList("true", "false"));
    
    
    protected String attributtion = ":=";
    protected String identifiers = "([a-z]|[A-Z])([0-9]|[a-z]+|[A-Z]|_)*";
    protected String intDigits = "[0-9]+";
    protected String floatDigits = "[0-9]+[.][0-9]+";
    
    protected ArrayList<String> myProgram = null;

    public Tokens(ArrayList<String> myArrayList) {
        this.myProgram = myArrayList;
    }
    
    public int lexicAnalizer() {
        
        for(int i = 0; i < this.myProgram.size(); i++) {
            String line = discardComments(this.myProgram.get(i));
            String[] splited = line.split("\\s+");
            
            //Verify line by line of the program
            for (int j = 0; j < splited.length; j++) {
                String token = splited[j];
                String result = checkToken(token);
                if(!result.equals("unknown")) {
//                    System.out.println(result + " : " + token);
                    System.out.println(token + " | "+ result + " |" + i);
                }
                else {
                    String subToken = token.substring(0, token.length() - 1);
                    result = checkToken(subToken);
                    if(!result.equals("unknown")) {
//                        System.out.println(result + " : " +subToken);
                        System.out.println(subToken + " | "+ result + " |" + i);
                        
                        String lastToken = token.substring(token.length() - 1, token.length());
                        result = checkToken(lastToken);
                        if(!result.equals("unknown")) {
//                            System.out.println(result + " : " +lastToken);
                            System.out.println(lastToken + " | "+ result + " |" + i);
                        }
                        else {
                            System.err.println("Error: Does not belong to language!");
                            System.err.println("Line: " + i + ", Status: " + result + " -> " + subToken);
                            return 0;
                        }
                    }
                    else {
                        System.err.println("Error: Does not belong to language!");
                        System.err.println("Line: " + i + ", Status: " + result + " -> " + subToken);
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
    
    private String discardComments(String line) {
        return line.replaceAll("\\{(?s).*?}", "");
    }
    
    private String checkToken(String split) {

        if (this.keyWords.contains(split)) {
            return "Keyword";
        } else if (this.delimiters.contains(split)) {
            return "Delimiter";
        } else if (this.operatiorsR.contains((split))) {
            return "Comparison Operator";
        } else if (this.operatiorsA.contains(split)) {
            return "Additive Operator";
        } else if (this.operatiorsM.contains(split)) {
            return "Multiplicative Operator";
        } else if (split.matches(this.intDigits)){
            return "Integer Digit";
        } else if (split.matches(this.floatDigits)) {
            return "Floating Point Digit";
        } else if (split.matches(this.identifiers)) {
            if (this.booleanDigits.contains(split)) {
                return "Boolean Digit";
            }
            return "Identifier";
        } else if (split.matches("\\{(?s).*?")) {
            return "unknown";
        }
        return "unknown";
    }    
}
