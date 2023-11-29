package cl.gabodev.crto.balger.exception;

public class StorageFileNotFoundException extends StorageException {

	private static final long serialVersionUID = 7519709334331051785L;

	public StorageFileNotFoundException(String message) {
		super(message);
	}

	public StorageFileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}