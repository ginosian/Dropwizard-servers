package com.dropwizard.resource;

import com.dropwizard.client.request.UserCreationRequestDto;
import com.dropwizard.client.request.UserUpdateRequestDto;
import com.dropwizard.client.responce.ApiSuccessResponse;
import com.dropwizard.client.responce.Response;
import com.dropwizard.client.responce.dto.UserDTO;
import io.swagger.annotations.*;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;



@SwaggerDefinition(
        consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML},
        produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML},
        tags = {
                @Tag(name = "api", description = "API & related"),
                @Tag(name = "user", description = "UserResource & related")
        },
        externalDocs = @ExternalDocs(
                value = "Simple CRUD operations with UserResource entity.",
                url = "https://localhost:8080/users"
        )
)
@Api(
        tags = {"dropwizard test api"}
)
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface UserResource {
    @ApiOperation(
            notes = "Gets complete info for UserResource with matching ID, throws exception if not found.",
            value = "Get UserResource by ID.",
            response = UserDTO.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful retrieval of UserResource info.", response = UserDTO.class)
    })
    @GET
    @Path("{userId}")
    Response<UserDTO> get(@PathParam("userId") Long userId);

    @ApiOperation(
            notes = "Creates UserResource, if successful returns success message.",
            value = "Creates UserResource.",
            response = ApiResponse.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful creation of UserResource.", response = ApiResponse.class)
    })
    @POST
    @Path("")
    Response<UserDTO> create(@Valid UserCreationRequestDto userCreationRequestDto);

    @ApiOperation(
            notes = "Updates UserResource, if successful returns success message.",
            value = "Updates UserResource.",
            response = ApiResponse.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful update of UserResource.", response = ApiResponse.class)
    })
    @PUT
    @Path("")
    Response<UserDTO> update(@Valid UserUpdateRequestDto userUpdateRequestDto);

    @ApiOperation(
            notes = "Deletes UserResource, if successful return success message.",
            value = "Deletes UserResource.",
            response = ApiResponse.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful deletion of UserResource.", response = ApiResponse.class)
    })
    @DELETE
    @Path("{userId}")
    Response<ApiSuccessResponse> delete(@PathParam("userId") Long userId);
}
