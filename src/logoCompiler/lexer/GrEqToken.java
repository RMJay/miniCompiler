package logoCompiler.lexer;

public class GrEqToken extends OperatorToken {
	//greater than or equal to
	@Override
	public String psOpCode() {
		// TODO Auto-generated method stub
		return "ge";
	}

	@Override
	public int precedence() {
		// TODO Auto-generated method stub
		return 1;
	}

	public String toString(){
		return "GrEqToken";
	}
	
}
