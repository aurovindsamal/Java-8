
public class EmailNotFoundException extends RuntimeException{
	
	private String message;
	
	EmailNotFoundException(String msg){
		super(msg);
		this.message=msg;
	}
}
