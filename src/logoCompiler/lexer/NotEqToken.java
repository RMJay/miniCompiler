package logoCompiler.lexer;

public class NotEqToken extends OperatorToken {

	@Override
	public String psOpCode() {
		return "ne";
	}

	@Override
	public int precedence() {
		return 1;
	}

	public String toString(){
		return "NotEqToken";
	}
	
}
