package org.dropwizard.test.resource;


import io.swagger.annotations.*;
import org.dropwizard.test.core.request.UserCreationRequestDto;
import org.dropwizard.test.core.request.UserUpdateRequestDto;
import org.dropwizard.test.core.responce.ApiResponse;
import org.dropwizard.test.core.responce.ApiSuccessResponse;
import org.dropwizard.test.core.responce.GenericListResponse;
import org.dropwizard.test.core.responce.dto.UserDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@SwaggerDefinition(
        consumes = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML},
        produces = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML},
        tags = {
                @Tag(name = "api", description = "API & related"),
                @Tag(name = "user", description = "User & related")
        },
        externalDocs = @ExternalDocs(
                value = "Simple CRUD operations with User entity.",
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
            notes = "Gets complete info for User with matching ID, throws exception if not found.",
            value = "Get User by ID.",
            response = UserDTO.class
    )
    @ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 200, message = "Successful retrieval of User info.", response = UserDTO.class)
    })
    @GET
    @Path("{userId}")
    ApiResponse<UserDTO> get(@PathParam("userId") String userId);

    @ApiOperation(
            notes = "Gets all Users with complete info.",
            value = "Lists all existing Users.",
            response = List.class
    )
    @ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 200, message = "Successful retrieval of API info.", response = List.class)
    })
    @GET
    @Path("")
    ApiResponse<GenericListResponse<UserDTO>> getALL();

    @ApiOperation(
            notes = "Creates User, if successful returns success message.",
            value = "Creates User.",
            response = ApiResponse.class
    )
    @ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 200, message = "Successful creation of User.", response = ApiResponse.class)
    })
    @POST
    @Path("")
    ApiResponse<ApiSuccessResponse> create(UserCreationRequestDto userCreationRequestDto);

    @ApiOperation(
            notes = "Updates User, if successful returns success message.",
            value = "Updates User.",
            response = ApiResponse.class
    )
    @ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 200, message = "Successful update of User.", response = ApiResponse.class)
    })
    @PUT
    @Path("")
    ApiResponse<ApiSuccessResponse> update(UserUpdateRequestDto userUpdateRequestDto);

    @ApiOperation(
            notes = "Deletes User, if successful return success message.",
            value = "Deletes User.",
            response = ApiResponse.class
    )
    @ApiResponses({
            @io.swagger.annotations.ApiResponse(code = 200, message = "Successful deletion of User.", response = ApiResponse.class)
    })
    @DELETE
    @Path("{userId}")
    ApiResponse<ApiSuccessResponse> delete(@PathParam("userId") String userId);






}
