package logoCompiler.parser;
import java.io.PrintWriter;

import  logoCompiler.lexer.*;

/*
 * binary-expr:
 *   expr op expr
 *
 *   where op is one of '+',  '-',  '*', '/',
 *                      '==', '!=', '>', '<', '<=', '>='
 */
public final class BinaryExpr extends Expr {
  public Expr  left;
  public OperatorToken oper;
  public Expr  right;

  public BinaryExpr(Expr left, OperatorToken oper, Expr right) {
    this.left  = left;
    this.oper  = oper;
    this.right = right;
  }


  @Override
public void codegen(PrintWriter p) {
    left.codegen(p);
    right.codegen(p);
    p.println(oper.psOpCode());
  }
}
