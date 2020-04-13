package org.people.xinghuo.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/demo")
public interface DemoService {
    @Path("/sayName")
    @POST
    @Consumes()
    String sayName(String name);
}
