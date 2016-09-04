package it.espr.mvc.test.gae;

public class EmptyBean {

	public void call() {
		System.out.println("Called method 'call()' on '" + this.getClass().getCanonicalName() + "'");
	}

	public void get(String id) {
		System.out.println("Called method 'get(" + id + ")' on '" + this.getClass().getCanonicalName() + "'");
	}

	public void post(String id, String data) {
		System.out.println("Called method 'post(" + id + "," + data + ")' on '" + this.getClass().getCanonicalName() + "'");
	}

	public void upload(String data) {
		System.out.println("Called method 'upload(" + data + ")' on '" + this.getClass().getCanonicalName() + "'");
	}
}
