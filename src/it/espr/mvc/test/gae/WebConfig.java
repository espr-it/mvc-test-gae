package it.espr.mvc.test.gae;

import it.espr.mvc.Configuration;

public class WebConfig extends Configuration {

	@Override
	protected void configureRoutes() {
		/*this.addRoute("/call", SimpleModel.class, "call");
		this.addRoute("/get", "get", SimpleModel.class, "get", new String[] { "id" });
		this.addRoute("/post", "post", SimpleModel.class, "post", new String[] { "id", "data" });
		this.addRoute("/upload", "post", SimpleModel.class, "upload", new String[] { "data" });

		this.addRoute("/bean/call", ModelWithInjections.class, "call");
		this.addRoute("/bean/get", "get", ModelWithInjections.class, "get", new String[] { "id" });
		this.addRoute("/bean/post", "post", ModelWithInjections.class, "post", new String[] { "id", "data" });
		this.addRoute("/bean/upload", "post", ModelWithInjections.class, "upload", new String[] { "data" });
*/
		this.addRoute("/([0-9]+:id)/(:type)", "get", ModelWithPathAttributes.class, "parse", new String[] { "filter" });
		this.addRoute("/o/([0-9]+:id)/(:type)", "get", ModelWithPathAttributes.class, "parseObject", new String[] { "filter" });
	}
}
