package logoCompiler.parser;

import java.io.PrintWriter;

import exceptions.FormatException;
import logoCompiler.lexer.*;

public class NumExpr extends PrimaryExpr {

	public int value;
	
	public NumExpr(int value){
		this.value = value;
	}
	
	public static NumExpr parse() throws FormatException{
		int value = ((NumToken)Parser.t).getAttr();
		Parser.t = Lexer.lex();
		return new NumExpr(value);
	}
	
	
	@Override
	public void codegen(PrintWriter p) {
		p.println(value);

	}

}
