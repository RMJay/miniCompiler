package logoCompiler.parser;

import java.io.PrintWriter;

import exceptions.FormatException;
import logoCompiler.lexer.*;

public class IdentExpr extends PrimaryExpr {

	public String name;
	
	public IdentExpr(String name){
		this.name = name;
	}
	
	public static IdentExpr parse() throws FormatException{
		String name = ((IdentToken)Parser.t).getAttr();
	    Parser.t = Lexer.lex();
		return new IdentExpr(name);
	}
	
	
	@Override
	public void codegen(PrintWriter p) {
		p.println("Arg");
	}

}
