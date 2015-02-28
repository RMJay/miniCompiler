package logoCompiler.lexer;

public class AddToken extends OperatorToken 
{

	@Override
	public String psOpCode()
	{
		return "add";
	}

	@Override
	public int precedence() 
	{
		return 2;
	}

	public String toString(){
		return "AddToken";
	}
	
}
