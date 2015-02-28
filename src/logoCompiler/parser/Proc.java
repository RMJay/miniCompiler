package logoCompiler.parser;

import logoCompiler.lexer.*;

import java.io.*;

import exceptions.FormatException;
import exceptions.UnexpectedTokenException;

/*
 * proc:
 *   "PROC" ident '(' ident ')' stmts 
 */
public final class Proc {
	String name;
	String arg;
	ProcStmts stmts;

	public Proc(String name, String arg, ProcStmts stmts) {
		this.name = name;
		this.arg = arg;
		this.stmts = stmts;
	}

	public static Proc parse() throws UnexpectedTokenException, FormatException{
		String name = "";
		String arg = "";
		ProcStmts stmts;

		Parser.t = Lexer.lex();

		if (Parser.t instanceof IdentToken) {
			name = ((IdentToken) Parser.t).getAttr();
			Parser.t = Lexer.lex();
		} else {
			throw new UnexpectedTokenException(Parser.t);
			//TODO
		}
		if (Parser.t instanceof LParenToken) {
			Parser.t = Lexer.lex();
		} else {
			throw new UnexpectedTokenException(Parser.t);
			//TODO
		}
		if (Parser.t instanceof IdentToken) {
			arg = ((IdentToken) Parser.t).getAttr();
			Parser.t = Lexer.lex();
		} else {
			throw new UnexpectedTokenException(Parser.t);
			//TODO
		}
		if (Parser.t instanceof RParenToken) {
			Parser.t = Lexer.lex();
		} else {
			throw new UnexpectedTokenException(Parser.t);
			//TODO
		}

		stmts = ProcStmts.parse();

		return new Proc(name, arg, stmts);
	}

	public void codegen(PrintWriter p) {
		p.println("/" + name + " {");
		stmts.codegen(p);
		p.println("} def");

	}
}
