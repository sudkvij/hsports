/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.21).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package io.swagger.api;

import io.swagger.model.InlineResponse500;
import io.swagger.model.Product;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.CookieValue;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-09-25T11:12:06.938Z[GMT]")
@Api(value = "product", description = "the product API")
public interface ProductApi {

    @ApiOperation(value = "", nickname = "productGet", notes = "", response = Product.class, responseContainer = "List", tags={ "product", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "This is a list of the products in the catalog", response = Product.class, responseContainer = "List"),
        @ApiResponse(code = 500, message = "This is an unexpected error", response = InlineResponse500.class) })
    @RequestMapping(value = "/product",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Product>> productGet(@ApiParam(value = "Page number to return") @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber
, @Max(100) @ApiParam(value = "Number of results in the page", allowableValues = "") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize
);


    @ApiOperation(value = "", nickname = "productPost", notes = "Add a product to the catalog", authorizations = {
        @Authorization(value = "password", scopes = { 
            @AuthorizationScope(scope = "write", description = "allows modifying resources"),
            @AuthorizationScope(scope = "read", description = "allows reading resources")
            })    }, tags={ "product", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "The product has been created."),
        @ApiResponse(code = 500, message = "This is an unexpected error", response = InlineResponse500.class) })
    @RequestMapping(value = "/product",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> productPost(@ApiParam(value = ""  )  @Valid @RequestBody Product body
);


    @ApiOperation(value = "", nickname = "productProductIdGet", notes = "", response = Product.class, tags={ "product", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "This is a list of the products in the catalog", response = Product.class),
        @ApiResponse(code = 500, message = "This is an unexpected error", response = InlineResponse500.class) })
    @RequestMapping(value = "/product/{productId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Product> productProductIdGet(@ApiParam(value = "",required=true) @PathVariable("productId") Integer productId
,@ApiParam(value = "" ) @RequestHeader(value="customer-security-header", required=false) Integer customerSecurityHeader
);

}

