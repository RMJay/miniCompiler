package logoCompiler;

import java.io.*;

import exceptions.FormatException;
import exceptions.UnexpectedTokenException;
import logoCompiler.lexer.*;
import logoCompiler.parser.*;

public class LogoPSCompiler {
	
	private static String name = "dragon"; 
	//Change this field to try compiling the various files in the logoPrograms folder
	//There is a class called test.LexerTest which has another main method which
	//prints out the chunks and tokens for the input file defined above and is useful for 
	//checking that the Lexer is working properly.
	public static String inputFile = "logoPrograms/" + name + ".t";
	public static String outputFile = "outputPostscript/" + name + ".ps";
	
	public static void main(String[] args) {

		try {
			Parser.t = Lexer.lex(); //this gets the next token
			Prog prog = Prog.parse(); //this attempts to 'understand' the input LOGO file

			if (!Parser.error) { //Parser.error is set to true when the exceptions get created
				PrintWriter p = new PrintWriter(outputFile);
				psPrologue(p);
				p.println("%XXXXXXXXXXXX_CODEGEN_START_XXXXXXXXXXXXXXX");
				prog.codegen(p);
				p.println("%XXXXXXXXXXXXX_CODEGEN_END_XXXXXXXXXXXXXXXX");
				psEpilogue(p);
				p.close();
			                    
			}

		} catch (UnexpectedTokenException e) {
			System.err.println(e.toString());
		} catch (FormatException e) {
			System.err.println(e.toString());
		} catch (FileNotFoundException e) {
			System.err.println(e.toString());
		}
	}



  public static void psPrologue(PrintWriter p) 
  { 
  p.println("%!PS-Adobe-3.0"); 
  //Adobe header // rest of prologue ... /
  p.println("/Xpos    { 300 } def");
  p.println("/Ypos    { 500 } def");
  p.println("/Heading { 0   } def");
  p.println("/Arg     { 0   } def"); 
  //Implementation of Right, Left and Forward procedures in PostScript 
  p.println("/Right   {");
  p.println("Heading exch add Trueheading");
  p.println("/Heading exch def"); 
  p.println("} def");
  p.println("/Left {");
  p.println("Heading exch sub Trueheading");
  p.println("/Heading exch def"); 
  p.println("} def");
  p.println("/Trueheading {"); 
  p.println("360 mod dup");
  p.println("0 lt { 360 add } if"); 
  p.println("} def");
  p.println("/Forward {"); 
  p.println("dup  Heading sin mul");
  p.println("exch Heading cos mul");
  p.println("2 copy Newposition"); 
  p.println("rlineto");
  p.println("} def"); 
  p.println("/Newposition {");
  p.println("Heading 180 gt Heading 360 lt");
  p.println("and { neg } if exch");
  p.println("Heading  90 gt Heading 270 lt");
  p.println("and { neg } if exch");
  p.println("Ypos add /Ypos exch def");
  p.println("Xpos add /Xpos exch def"); 
  p.println("} def"); 
  }
  
  public static void psEpilogue(PrintWriter p) 
  { // epilogue ... /
	  p.println("Xpos Ypos moveto"); //Call Main to start
	  p.println("MAIN"); 
	  p.println("stroke");
	  p.println("showpage"); 
  } 
  
}
 
