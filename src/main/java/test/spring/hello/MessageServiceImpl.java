package test.spring.hello;

public class MessageServiceImpl implements MessageService {

	private String message;
	
	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
