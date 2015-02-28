package logoCompiler.parser;

import java.io.PrintWriter;

import exceptions.FormatException;
import exceptions.UnexpectedTokenException;
import logoCompiler.lexer.*;

/*
 *   "LEFT" expr
 */
public class RightStmt extends Stmt {
	
	Expr expr;

	public RightStmt(Expr expr) {
		this.expr = expr;
	}

	public static RightStmt parse() throws UnexpectedTokenException, FormatException {
		Parser.t = Lexer.lex();
		Expr expr = Expr.parse();
		return new RightStmt(expr);
	}

	@Override
	public void codegen(PrintWriter p) {
		expr.codegen(p);
		p.println("Right");
	}
}
