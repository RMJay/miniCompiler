package logoCompiler.parser;

import java.io.*;
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
public class ProcStmts {

	List<Stmt> stmts;

	public ProcStmts(List<Stmt> stmts) {
		this.stmts = stmts;
	}

	public static ProcStmts parse() throws UnexpectedTokenException, FormatException{
		List<Stmt> stmts = new ArrayList<Stmt>();
		stmts.add(Stmt.parse());

		while ((Parser.t instanceof ForwardToken)
				|| (Parser.t instanceof LeftToken)
				|| (Parser.t instanceof RightToken)
				|| (Parser.t instanceof IfToken)
				|| (Parser.t instanceof IdentToken)) {
			stmts.add(Stmt.parse());
		}
		if ((Parser.t instanceof PROCToken) || (Parser.t instanceof EOIToken)) {
		} else {
			throw new UnexpectedTokenException(Parser.t);
			//TODO
		}
		return new ProcStmts(stmts);

	}

	public void codegen(PrintWriter p) {
		ListIterator<Stmt> li = stmts.listIterator();
		while (li.hasNext()) {
			li.next().codegen(p);
		}
		
	}


}
