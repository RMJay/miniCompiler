package logoCompiler.lexer;

public class SubToken extends OperatorToken 
{

	@Override
	public String psOpCode() 
	{
		return "sub";
	}

	@Override
	public int precedence() 
	{
		return 2;
	}
	
	public String toString(){
		return "SubToken";
	}
}
