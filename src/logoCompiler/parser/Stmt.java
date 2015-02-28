package logoCompiler.parser;

import java.io.*;

import exceptions.FormatException;
import exceptions.UnexpectedTokenException;
import logoCompiler.lexer.*;

/*
 * stmt:
 *   ForwardStmt
 *   LeftStmt
 *   RightStmt
 *   IFStmt
 *   SubProc
 */
public abstract class Stmt{

	public static Stmt parse() throws UnexpectedTokenException, FormatException{

		Stmt stmt;
		
		if (Parser.t instanceof ForwardToken) {
			stmt = ForwardStmt.parse();
		} else if (Parser.t instanceof LeftToken) {
			stmt = LeftStmt.parse();
		} else if (Parser.t instanceof RightToken) {
			stmt = RightStmt.parse();
		} else if (Parser.t instanceof IfToken) {
			stmt = IFStmt.parse();
		} else if (Parser.t instanceof IdentToken) {
			stmt = SubProc.parse();
		} else {
			throw new UnexpectedTokenException(Parser.t);
			//TODO
		}
		return stmt;

	}

	public abstract void codegen(PrintWriter p);

}
