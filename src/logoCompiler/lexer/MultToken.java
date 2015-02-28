package logoCompiler.lexer;

public class MultToken extends OperatorToken 
{

	@Override
	public String psOpCode() 
	{
		return "mul";
	}

	@Override
	public int precedence() 
	{
		return 3;
	}

	public String toString(){
		return "MultToken";
	}
	
}
