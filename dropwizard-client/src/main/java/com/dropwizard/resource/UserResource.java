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
                @Tag(name = "user", description = "UserClient & related")
        },
        externalDocs = @ExternalDocs(
                value = "Simple CRUD operations with UserClient entity.",
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
            notes = "Gets complete info for UserClient with matching ID, throws exception if not found.",
            value = "Get UserClient by ID.",
            response = UserDTO.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful retrieval of UserClient info.", response = UserDTO.class)
    })
    @GET
    @Path("{userId}")
    Response<UserDTO> get(@PathParam("userId") Long userId);

    @ApiOperation(
            notes = "Creates UserClient, if successful returns success message.",
            value = "Creates UserClient.",
            response = ApiResponse.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful creation of UserClient.", response = ApiResponse.class)
    })
    @POST
    @Path("")
    Response<UserDTO> create(@Valid UserCreationRequestDto userCreationRequestDto);

    @ApiOperation(
            notes = "Updates UserClient, if successful returns success message.",
            value = "Updates UserClient.",
            response = ApiResponse.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful update of UserClient.", response = ApiResponse.class)
    })
    @PUT
    @Path("")
    Response<UserDTO> update(@Valid UserUpdateRequestDto userUpdateRequestDto);

    @ApiOperation(
            notes = "Deletes UserClient, if successful return success message.",
            value = "Deletes UserClient.",
            response = ApiResponse.class
    )
    @ApiResponses({
            @ApiResponse(code = 200, message = "Successful deletion of UserClient.", response = ApiResponse.class)
    })
    @DELETE
    @Path("{userId}")
    Response<ApiSuccessResponse> delete(@PathParam("userId") Long userId);
}
