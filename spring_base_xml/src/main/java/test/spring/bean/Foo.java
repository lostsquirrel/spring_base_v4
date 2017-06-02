package test.spring.bean;

public class Foo {

	private String fooMessage;

	public String getFooMessage() {
		return fooMessage;
	}

	public void setFooMessage(String fooMessage) {
		this.fooMessage = fooMessage;
	}

	@Override
	public String toString() {
		return "Foo [fooMessage=" + fooMessage + "]";
	}
	
}
