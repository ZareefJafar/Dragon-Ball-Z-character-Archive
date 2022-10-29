package zareef.dbz.DragonBallZCharacters.exception;

public class characterCollectionException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public characterCollectionException(String message) {
		super(message);
	}
	
	public static String NotFoundException(String id) {
		return "Character with "+id+" not found";
	}
	
	public static String characterAlreadyExists() {
		return "Character with given name already exists";
	}

}
