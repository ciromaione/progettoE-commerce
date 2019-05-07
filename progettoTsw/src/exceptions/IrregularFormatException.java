package exceptions;

public class IrregularFormatException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	
	public IrregularFormatException() {
		super("formato non regolare!");
	}
	
	public IrregularFormatException(String msg) {
		super(msg);
	}
	
}
