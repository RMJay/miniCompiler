package logoCompiler.parser;

import java.io.PrintWriter;

import exceptions.FormatException;
import exceptions.UnexpectedTokenException;
import logoCompiler.lexer.*;

/*
 * expr:
 *   primary-expr 
 *   binary-expr 
 */
public abstract class Expr{

	  public static Expr parse() throws UnexpectedTokenException, FormatException{
		    return fraserHanson(1);
	  }

	  //Binary Expressions precedence handler from Fraser and Hanson C Compiler book
	  private static Expr fraserHanson(int k) throws UnexpectedTokenException, FormatException{
		  int   i;
		  Expr  left;
		  OperatorToken oper;
		  Expr  right;
		  left = PrimaryExpr.parse();
		  
		  for (i = Parser.t.precedence(); i >= k; i--) {
		    while (Parser.t.precedence() == i) {
		      oper = (OperatorToken) Parser.t; 
		      Parser.t = Lexer.lex();
		      right = fraserHanson(i+1);
		      left  = new BinaryExpr(left, oper, right); 
		    }
		  }
		  return left;
	  }

  public abstract void codegen(PrintWriter p);
}
