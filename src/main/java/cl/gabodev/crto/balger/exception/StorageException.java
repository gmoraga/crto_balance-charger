package cl.gabodev.crto.balger.exception;

public class StorageException extends RuntimeException {

	private static final long serialVersionUID = 6823637318470221545L;

	public StorageException(String message) {
		super(message);
	}

	public StorageException(String message, Throwable cause) {
		super(message, cause);
	}
}