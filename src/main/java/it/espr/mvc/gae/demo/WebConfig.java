package it.espr.mvc.gae.demo;

import it.espr.mvc.Configuration;

public class WebConfig extends Configuration {

	@Override
	protected void configureRoutes() {
		
		// all GET requests to url /call are being routed to SimpleModel method "call"
		this.addRoute("/call", SimpleModel.class, "call");

		// all GET requests to url /get are being routed to SimpleModel method "get" and pass request parameter "id"
		this.addRoute("/get", "get", SimpleModel.class, "get", new String[] { "id" });
		
		// all POST requests to url /post are being routed to SimpleModel method "post" and pass request parameters "id" & "data"
		this.addRoute("/post", "post", SimpleModel.class, "post", new String[] { "id", "data" });

		// all POST requests to url /upload are being routed to SimpleModel method "upload" and pass request parameter "data"
		this.addRoute("/upload", "post", SimpleModel.class, "upload", new String[] { "data" });

		// similar as above just the ModelWithInjections contains @Injected bean
		this.addRoute("/bean/call", ModelWithInjections.class, "call");
		this.addRoute("/bean/get", "get", ModelWithInjections.class, "get", new String[] { "id" });
		this.addRoute("/bean/post", "post", ModelWithInjections.class, "post", new String[] { "id", "data" });
		this.addRoute("/bean/upload", "post", ModelWithInjections.class, "upload", new String[] { "data" });

		// path variables examples
		// url "/342435/add" will call ModelWithPathAttributes method "parse" with parameters "id=342435" & "type=add"
		this.addRoute("/([0-9]+:id)/(:type)", "get", ModelWithPathAttributes.class, "parse", new String[] { "filter" });
		
		// similar to above, but this time we pass path variables "id=342435" & "type=add" plus request parameter "filter"
		this.addRoute("/o/([0-9]+:id)/(:type)", "get", ModelWithPathAttributes.class, "parseObject", new String[] { "filter" });
	}
}
