package logoCompiler.parser;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import exceptions.FormatException;
import exceptions.UnexpectedTokenException;
import logoCompiler.lexer.*;

/*
 * stmts:
 *   { stmt } 
 */
public class ThenStmts {

	List<Stmt> stmts;

	public ThenStmts(List<Stmt> stmts) {
		this.stmts = stmts;
	}

	public static ThenStmts parse() throws UnexpectedTokenException, FormatException{
		List<Stmt> stmts = new ArrayList<Stmt>();
		stmts.add(Stmt.parse());

		while ((Parser.t instanceof ForwardToken)
				|| (Parser.t instanceof LeftToken)
				|| (Parser.t instanceof RightToken)
				|| (Parser.t instanceof IfToken)
				|| (Parser.t instanceof IdentToken)) {
			stmts.add(Stmt.parse());
		}
		if (Parser.t instanceof ElseToken) {
		} else {
			throw new UnexpectedTokenException(Parser.t);
			//TODO
		}
		return new ThenStmts(stmts);

	}
	
	public void codegen(PrintWriter p) {
		ListIterator<Stmt> li = stmts.listIterator();
		while (li.hasNext()) {
			li.next().codegen(p);
		}
	}
}