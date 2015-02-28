package logoCompiler.lexer;

public class EqToken extends OperatorToken {

	@Override
	public String psOpCode() {
		return "eq";
	}

	@Override
	public int precedence() {
		return 1;
	}
	
	public String toString(){
		return "EqToken";
	}

}
