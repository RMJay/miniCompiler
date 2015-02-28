package logoCompiler.parser;

import java.io.PrintWriter;

import exceptions.FormatException;
import exceptions.UnexpectedTokenException;
import logoCompiler.lexer.*;

/*
 *   "IF" expr "THEN" stmts "ELSE" stmts "ENDIF"
 */
public class IFStmt extends Stmt {

	Expr expr;
	ThenStmts thenStmts;
	ElseStmts elseStmts;

	public IFStmt(Expr expr, ThenStmts thenStmts, ElseStmts elseStmts) {
		this.expr = expr;
		this.thenStmts = thenStmts;
		this.elseStmts = elseStmts;
	}

	public static IFStmt parse() throws UnexpectedTokenException, FormatException {
		Expr expr;
		ThenStmts thenStmts = null;
		ElseStmts elseStmts = null;

		Parser.t = Lexer.lex();
		expr = Expr.parse();

		if (Parser.t instanceof ThenToken) {
			Parser.t = Lexer.lex();
			thenStmts = ThenStmts.parse();
		} else {
			throw new UnexpectedTokenException(Parser.t);
			//TODO 
		}
		
		if (Parser.t instanceof ElseToken) {
			Parser.t = Lexer.lex();
			elseStmts = ElseStmts.parse();
		} else {
			throw new UnexpectedTokenException(Parser.t);
			// TODO
		} 
		
		if (Parser.t instanceof EndIfToken) {
			Parser.t = Lexer.lex();
		} else {
			throw new UnexpectedTokenException(Parser.t);
			// TODO
		}
		
		return new IFStmt(expr, thenStmts, elseStmts);

	}

	@Override
	public void codegen(PrintWriter p) {
		expr.codegen(p);
		p.println("{\t");
		thenStmts.codegen(p);  
		p.println("}{\t");
		elseStmts.codegen(p);
		p.println("} ifelse");
	}
}
