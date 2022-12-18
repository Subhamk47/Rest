package org.subham.javaworld.Messenger.Resources;

import java.net.URI;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectDemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	// Access of Matrix param
	@GET
	@Path("/annotation")
	public String getParamsUsingAnnotations(@MatrixParam("param") String param) {
		System.out.println(param);
		return "Hello World !";
	}
	// Access of Header and cookie
	@GET
	@Path("/annotations")
	public String useOfHeaderCookieParam(@HeaderParam("authSession") String authSession,@CookieParam("name") String name ) {
		return "Hellow "+authSession+ " cookie value is "+ name; 
	}
	
	// Access of Context
	/*
	 * We can use Context param to access anything if we don't know how many headers value are there or what is the name of value
	 * we can use Context get everything and their detials
	 * Even we will get path information and query param as well as path param and many more just need to use UriInfo
	 */
	/*
	 * HttpHeader is used to get the information for headers and cookies specifically
	 */
	@GET
	@Path("context")
	public String getParamUsingContext(@Context UriInfo uriInfo , @Context HttpHeaders headers) {
		URI path = uriInfo.getAbsolutePath();
		uriInfo.getQueryParameters();
		uriInfo.getPathParameters();
		headers.getAcceptableMediaTypes();
		headers.getDate();
		headers.getRequestHeaders();
		Map<String, Cookie> st = headers.getCookies();// another way to access cookie information
		return "test "+ path.toString();
	}
}
