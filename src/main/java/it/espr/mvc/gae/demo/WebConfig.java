package it.espr.mvc.gae.demo;

import it.espr.mvc.Configuration;

public class WebConfig extends Configuration {

	@Override
	protected void configureMvc() {
		
		// all GET requests to url /call are being routed to SimpleModel method "call"
		route().get("/call").to(SimpleModel.class, "call");

		// all GET requests to url /get are being routed to SimpleModel method "get" and pass request parameter "id"
		route().get("/get").to(SimpleModel.class, "get").with("id");
		
		// all POST requests to url /post are being routed to SimpleModel method "post" and pass request parameters "id" & "data"
		route().post("/post").to(SimpleModel.class, "post").with("id", "data");

		// all POST requests to url /upload are being routed to SimpleModel method "upload" and pass request parameter "data"
		route().post("/upload").to(SimpleModel.class, "upload").with("data");

		// similar as above just the ModelWithInjections contains @Injected bean
		route().get("/bean/call").to(ModelWithInjections.class, "call");
		route().get("/bean/get").to(ModelWithInjections.class, "get").with("id");
		route().post("/bean/post").to(ModelWithInjections.class, "post").with("id", "data");
		route().post("/bean/upload").to(ModelWithInjections.class, "upload").with("data");

		// path variables examples
		// url "/342435/add" will call ModelWithPathAttributes method "parse" with parameters "id=342435" & "type=add"
		route().get("/([0-9]+:id)/(:type)").to(ModelWithPathAttributes.class, "parse").with("filter");
		
		// similar to above, but this time we pass path variables "id=342435" & "type=add" plus request parameter "filter"
		route().get("/o/([0-9]+:id)/(:type)").to(ModelWithPathAttributes.class, "parseObject").with("filter");
	}
}
