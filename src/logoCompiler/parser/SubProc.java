package logoCompiler.parser;

import java.io.PrintWriter;

import exceptions.FormatException;
import exceptions.UnexpectedTokenException;
import logoCompiler.lexer.*;

/*
 *   ident '(' expr ')'
 */
public class SubProc extends Stmt {
	String name;
	Expr arg;

	public SubProc(String name, Expr arg) {
		this.name = name;
		this.arg = arg;
	}

	public static SubProc parse() throws UnexpectedTokenException, FormatException {
		String name;
		Expr arg;

		if (Parser.t instanceof IdentToken) {
			name = ((IdentToken) Parser.t).getAttr();
			Parser.t = Lexer.lex();
		} else {
			throw new UnexpectedTokenException(Parser.t);
			// TODO
		}

		if (Parser.t instanceof LParenToken) {
			Parser.t = Lexer.lex();
		} else {
			throw new UnexpectedTokenException(Parser.t);
			// TODO
		}

		arg = Expr.parse();

		if (Parser.t instanceof RParenToken) {
			Parser.t = Lexer.lex();
		} else {
			throw new UnexpectedTokenException(Parser.t);
			// TODO
		}

		return new SubProc(name, arg);

	}

	@Override
	public void codegen(PrintWriter p) {
		p.println("Arg"); // store the value of Arg to the stack so that after the procedure is run Arg can be restored
		arg.codegen(p);
		p.println("/Arg exch def");
		p.println(name);
		p.println("/Arg exch def"); // restore Arg to what it was before the procedure call
		


	}

}
