package logoCompiler.parser;

import java.io.PrintWriter;

import exceptions.FormatException;
import exceptions.UnexpectedTokenException;
import logoCompiler.lexer.*;

/*
 *   "LEFT" expr
 */
public class LeftStmt extends Stmt {
	
	Expr expr;

	public LeftStmt(Expr expr) {
		this.expr = expr;
	}

	public static LeftStmt parse() throws UnexpectedTokenException, FormatException {
		Parser.t = Lexer.lex();
		Expr expr = Expr.parse();
		return new LeftStmt(expr);
	}

	@Override
	public void codegen(PrintWriter p) {
		expr.codegen(p);
		p.println("Left");
	}
}
