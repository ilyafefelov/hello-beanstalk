package xyz.jacobclark.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/hello-beanstalk")
public class HelloBeanstalkResource {
    @GET
    public String hello(){
        return "Hello Beanstalk";
    }
}
