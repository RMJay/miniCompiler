package logoCompiler.lexer;

public class GrToken extends OperatorToken 
{

	@Override
	public String psOpCode() {
		// TODO Auto-generated method stub
		return "gt";
	}

	@Override
	public int precedence() {
		// TODO Auto-generated method stub
		return 1;
	}
	
	public String toString(){
		return "GrToken";
	}
}
