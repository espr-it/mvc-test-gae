package it.espr.mvc.test.gae;

public class ModelWithPathAttributes {

	public static class Result {
		public String id;
		public String type;
		public String filter;

		public Result(String id, String type, String filter) {
			super();
			this.id = id;
			this.type = type;
			this.filter = filter;
		}
	}

	public String parse(String id, String type, String filter) {
		return "id: " + id + ", type: " + type + ", filter: " + filter;
	}

	public Result parseObject(String id, String type, String filter) {
		return new Result(id, type, filter);
	}

}
