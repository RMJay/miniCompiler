package logoCompiler.lexer;

public class LeToken extends OperatorToken {
	//less than token
	@Override
	public String psOpCode() {
		return "lt";
	}

	@Override
	public int precedence() {
		return 1;
	}

	public String toString(){
		return "LeToken";
	}
	
}
