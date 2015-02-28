package logoCompiler.lexer;

public class LeEqToken extends OperatorToken {
	//less than or equal to
	@Override
	public String psOpCode() {
		return "le";
	}

	@Override
	public int precedence() {
		return 1;
	}

	public String toString(){
		return "LeEqToken";
	}
	
}
