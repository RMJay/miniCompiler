package logoCompiler.parser;

import logoCompiler.lexer.*;

import java.io.*;
import java.util.*;

import exceptions.FormatException;
import exceptions.UnexpectedTokenException;

/*
 * prog:
 *   { proc }
 */
public class Prog {

	List<Proc> procs;

	public Prog(List<Proc> procs) {
		this.procs = procs;
	}

	public static Prog parse() throws UnexpectedTokenException, FormatException{
		List<Proc> procs = new ArrayList<Proc>();
		procs.add(Proc.parse());

		while (Parser.t instanceof PROCToken) {
			procs.add(Proc.parse());
			if (Parser.t instanceof EOIToken) {
				break;
			}
		}
		return new Prog(procs);
	}

	public void codegen(PrintWriter p) {
		ListIterator<Proc> li = procs.listIterator();
		while (li.hasNext()) {
			li.next().codegen(p);
		}
	}
}
