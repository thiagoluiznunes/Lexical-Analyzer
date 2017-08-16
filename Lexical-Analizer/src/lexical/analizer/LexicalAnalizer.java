/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexical.analizer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 *
 * @author thiago
 */
public class LexicalAnalizer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

    // Open the file
    FileInputStream fstream = new FileInputStream("src/lexical/analizer/textfile");
    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

    String strLine;
    ArrayList<String> lines = new ArrayList<String> ();

    //Read File Line By Line
    while ((strLine = br.readLine()) != null)   {
      lines.add(strLine);
        System.out.println(strLine);
    }
    //Close the input stream
    br.close();
    
    Tokens token = new Tokens(lines);
    
    }
    
}
