package it.espr.mvc.test.gae;

import java.util.Random;

import javax.inject.Inject;

public class ModelWithInjections {

	@Inject
	private EmptyBean bean;

	public void call() {
		this.bean.call();
	}

	public Integer get(String id) {
		this.bean.get(id);
		return new Random().nextInt();
	}

	public void post(String id, String data) {
		this.bean.post(id, data);
	}

	public void upload(String data) {
		this.bean.upload(data);
	}
}
