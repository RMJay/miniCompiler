package logoCompiler.parser;
import  logoCompiler.lexer.*;

public final class Parser {
  public static Token t; //A placeholder for the current token
  public static boolean error = false; 
  //Inside the constructor of FormatException and UnexpectedTokenException this 
  //error field is set to be true, therefore whenever a new error is created 
  //Parser.error is set to true.
}
