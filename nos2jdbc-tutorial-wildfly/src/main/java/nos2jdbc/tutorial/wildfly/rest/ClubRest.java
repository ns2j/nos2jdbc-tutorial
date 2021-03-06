package nos2jdbc.tutorial.wildfly.rest;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import java.util.List;

import nos2jdbc.tutorial.wildfly.gen.entity.Club;
import nos2jdbc.tutorial.wildfly.service.ClubMemberRelService;
import nos2jdbc.tutorial.wildfly.service.ClubService;

@Path("/club")
@RequestScoped
public class ClubRest {
    @Inject
    ClubService clubService;
    
    @Inject
    ClubMemberRelService relService;

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    //@Transactional
    public Response getList() {
	relService.insertData();
        
	List<Club> cs = clubService.findAllWithMembers();
        ResponseBuilder rb = Response.ok(cs);
        return rb.build();
    }
}
