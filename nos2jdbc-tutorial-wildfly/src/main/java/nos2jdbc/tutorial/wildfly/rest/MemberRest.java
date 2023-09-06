package nos2jdbc.tutorial.wildfly.rest;


import java.util.List;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import nos2jdbc.tutorial.wildfly.entity.Member;
import nos2jdbc.tutorial.wildfly.service.ClubMemberRelService;
import nos2jdbc.tutorial.wildfly.service.MemberService;


@Path("/member")
@RequestScoped
public class MemberRest {
    @Inject
    MemberService memberService;
    
    @Inject
    ClubMemberRelService relService;

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    //@Transactional
    public Response getList() {
	relService.insertData();
        
	List<Member> cs = memberService.findAllWithClubs();
        ResponseBuilder rb = Response.ok(cs);
        return rb.build();
    }
}
