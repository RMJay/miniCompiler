package logoCompiler.parser;

import java.io.PrintWriter;

import exceptions.FormatException;
import exceptions.UnexpectedTokenException;
import logoCompiler.lexer.*;

/*
 *   "FORWARD" expr
 */
public class ForwardStmt extends Stmt {
	
	Expr expr;

	public ForwardStmt(Expr expr) {
		this.expr = expr;
	}

	public static ForwardStmt parse() throws UnexpectedTokenException, FormatException {
		Parser.t = Lexer.lex();
		Expr expr = Expr.parse();
		return new ForwardStmt(expr);
	}

	@Override
	public void codegen(PrintWriter p) {
		expr.codegen(p);
		p.println("Forward");
	}
}

