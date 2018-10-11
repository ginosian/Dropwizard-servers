package com.dropwizard.test.resource;


import com.dropwizard.test.core.request.UserCreationRequestDto;
import com.dropwizard.test.core.request.UserUpdateRequestDto;
import com.dropwizard.test.core.responce.ApiResponse;
import com.dropwizard.test.core.responce.AdiSuccessResponse;
import com.dropwizard.test.core.responce.dto.UserDto;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UserResource {

    @GET
    @Path("{userId}")
    ApiResponse<UserDto> get(@PathParam("userId") String userId);

    @GET
    @Path("")
    ApiResponse<UserDto> getALL();

    @POST
    @Path("")
    ApiResponse<AdiSuccessResponse> create(UserCreationRequestDto userCreationRequestDto);

    @PUT
    @Path("")
    ApiResponse<AdiSuccessResponse> update(UserUpdateRequestDto userUpdateRequestDto);

    @DELETE
    @Path("{userId}")
    ApiResponse<AdiSuccessResponse> delete(@PathParam("userId") String userId);






}
