package cl.gabodev.crto.balger.exception;

public class FileLoadException extends RuntimeException {

	private static final long serialVersionUID = -6355338189241373654L;

	public FileLoadException(String message) {
		super(message);
	}

	public FileLoadException(String message, Throwable cause) {
		super(message, cause);
	}
}