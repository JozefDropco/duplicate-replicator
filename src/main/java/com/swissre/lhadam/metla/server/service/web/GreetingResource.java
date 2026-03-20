//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.swissre.lhadam.metla.server.service.web;

import io.smallrye.faulttolerance.api.RateLimit;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;
import java.util.function.Function;
import java.util.logging.Logger;

@Tag(
        name = "Database Data Source",
        description = "API for managing database data sources"
)
@Path("/data-source")
public class GreetingResource {
    private static final Logger LOGGER = Logger.getLogger(GreetingResource.class.getName());

    @Context
    private SecurityContext context;
    private static final Function<SecurityContext, String> getUserName = (securityContext) -> securityContext.getUserPrincipal().getName();

    @Path("/clear")
    @GET
    @RateLimit(2)
    public Response clear() {
        String userName = (String)getUserName.apply(this.context);
        LOGGER.info(String.format("User '%s' initiated clearing of Datasource cache.", userName));
        return Response.ok().build();
    }

    @GET
    @Path("/all")
    @Operation(
            summary = "Get all data sources",
            description = "Returns a list of all data sources."
    )
    @ApiResponses({@ApiResponse(
            responseCode = "200",
            description = "List of data sources",
            content = {@Content(
                    array = @ArraySchema(
                            schema = @Schema(
                                    implementation = GreetingResource.class
                            )
                    )
            )}
    )})
    public Response getAllDataSources() {
        return Response.ok().build();
    }

    @GET
    @Path("/by-ref-cd")
    @Operation(
            summary = "Get data source by refCd",
            description = "Returns a data source by its refCd."
    )
    @ApiResponses({@ApiResponse(
            responseCode = "200",
            description = "Data source found",
            content = {@Content(
                    schema = @Schema(
                            implementation = GreetingResource.class
                    )
            )}
    ), @ApiResponse(
            responseCode = "404",
            description = "Data source not found"
    )})
    public Response getDataSourceByRefCd(@QueryParam("refCd") String refCd) {
        return Response.ok().build();
    }

    @POST
    @Path("/")
    @Consumes({"application/json"})
    @Operation(
            summary = "Create a data source",
            description = "Creates a new data source."
    )
    @ApiResponses({@ApiResponse(
            responseCode = "201",
            description = "Data source created"
    )})
    @RequestBody(
            description = "DataSourceRequest payload",
            required = true,
            content = {@Content(
                    schema = @Schema(
                            implementation = GreetingResource.class
                    )
            )}
    )
    public Response createDataSource(String dataSourceJson) {
        return Response.ok().build();
    }

    @PUT
    @Path("/")
    @Consumes({"application/json"})
    @Operation(
            summary = "Update a data source",
            description = "Updates an existing data source by refCd."
    )
    @ApiResponses({@ApiResponse(
            responseCode = "200",
            description = "Data source updated"
    )})
    @RequestBody(
            description = "DataSourceRequest payload",
            required = true,
            content = {@Content(
                    schema = @Schema(
                            implementation = GreetingResource.class
                    )
            )}
    )
    public Response updateDataSource(@QueryParam("refCd") String refCd, String dataSourceJson) {
        return Response.ok().build();
    }

    @PUT
    @Path("/{refCd}/jdbc-url")
    @Operation(
            summary = "Update JDBC URL for a data source",
            description = "Updates only the JDBC URL of the data source identified by refCd."
    )
    @ApiResponses({@ApiResponse(
            responseCode = "200",
            description = "JDBC URL updated"
    ), @ApiResponse(
            responseCode = "404",
            description = "Data source not found"
    )})
    public Response updateJdbcUrl(@PathParam("refCd") String refCd, @QueryParam("newJdbcUrl") String newJdbcUrl) {
        return Response.ok().build();
    }

    @DELETE
    @Path("/")
    @Operation(
            summary = "Delete a data source",
            description = "Deletes a data source by refCd."
    )
    @ApiResponses({@ApiResponse(
            responseCode = "200",
            description = "Data source deleted"
    ), @ApiResponse(
            responseCode = "404",
            description = "Data source not found"
    )})
    public Response deleteDataSource(@QueryParam("refCd") String refCd) {
        return Response.ok().build();
    }
}
