package demo.gateway;

/**
 * @author ecabrerar
 * @since Aug 26, 2020
 */
public class ExceptionOGBT extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ExceptionOGBT() {
		super();		
	}

	public ExceptionOGBT(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ExceptionOGBT(String message, Throwable cause) {
		super(message, cause);
	}

	public ExceptionOGBT(String message) {
		super(message);
	}

	public ExceptionOGBT(Throwable cause) {
		super(cause);
	}


}
