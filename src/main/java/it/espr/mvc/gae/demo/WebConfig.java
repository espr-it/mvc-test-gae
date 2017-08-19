package it.espr.mvc.gae.demo;

import static it.espr.mvc.route.parameter.Parameter.body;
import static it.espr.mvc.route.parameter.Parameter.param;

import it.espr.mvc.MvcConfiguration;

public class WebConfig extends MvcConfiguration {

	@Override
	protected void configureMvc() {

		// all GET requests to url /call are being routed to SimpleModel method
		// "call"
		route().get("/call").to(SimpleModel.class, "call");

		// all GET requests to url /get are being routed to SimpleModel method "get"
		// and pass request parameter "id"
		route().get("/get").to(SimpleModel.class, "get").params("id");

		// all POST requests to url /post are being routed to SimpleModel method
		// "post" and pass request parameters "id" & "data"
		route().post("/post").to(SimpleModel.class, "post").params("id", "data");

		// all POST requests to url /upload are being routed to SimpleModel method
		// "upload" and pass request parameter "data"
		route().post("/upload").to(SimpleModel.class, "upload").params(body());

		// similar as above just the ModelWithInjections contains @Injected bean
		route().get("/bean/call").to(ModelWithInjections.class, "call");
		route().get("/bean/get").to(ModelWithInjections.class, "get").params("id");
		route().post("/bean/post").to(ModelWithInjections.class, "post").params(param("id"), body());
		route().post("/bean/upload").to(ModelWithInjections.class, "upload").params(body());

		// path variables examples
		// url "/342435/add" will call ModelWithPathAttributes method "parse" with
		// parameters "id=342435" & "type=add"
		route().get("/([0-9]+:id)/(:type)").to(ModelWithPathAttributes.class, "parse").params("filter");

		// similar to above, but this time we pass path variables "id=342435" &
		// "type=add" plus request parameter "filter"
		route().get("/o/([0-9]+:id)/(:type)").to(ModelWithPathAttributes.class, "parseObject").params("filter");
	}
}
