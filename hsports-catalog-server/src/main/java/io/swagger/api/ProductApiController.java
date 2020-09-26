package io.swagger.api;

import io.swagger.model.InlineResponse500;
import io.swagger.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2020-09-25T11:12:06.938Z[GMT]")
@Controller
public class ProductApiController implements ProductApi {

    private static final Logger log = LoggerFactory.getLogger(ProductApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    ProductService productService;

    @org.springframework.beans.factory.annotation.Autowired
    public ProductApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Product>> productGet(@ApiParam(value = "Page number to return") @Valid @RequestParam(value = "pageNumber", required = false) Integer pageNumber
, @Max(100) @ApiParam(value = "Number of results in the page", allowableValues = "") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Product>>(objectMapper.readValue("[ {\n  \"image\" : \"https://hplussport.com/images/1234\",\n  \"name\" : \"Lemon Water\",\n  \"description\" : \"Lemon Water\",\n  \"id\" : 400,\n  \"image_title\" : \"mineral-water-lemon-lime\"\n}, {\n  \"image\" : \"https://hplussport.com/images/1234\",\n  \"name\" : \"Lemon Water\",\n  \"description\" : \"Lemon Water\",\n  \"id\" : 400,\n  \"image_title\" : \"mineral-water-lemon-lime\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Product>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Product>>(this.productService.getProducts(),HttpStatus.OK);
    }

    public ResponseEntity<Void> productPost(@ApiParam(value = ""  )  @Valid @RequestBody Product body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Product> productProductIdGet(@ApiParam(value = "",required=true) @PathVariable("productId") Integer productId
,@ApiParam(value = "" ) @RequestHeader(value="customer-security-header", required=false) Integer customerSecurityHeader
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Product>(objectMapper.readValue("{\n  \"image\" : \"https://hplussport.com/images/1234\",\n  \"name\" : \"Lemon Water\",\n  \"description\" : \"Lemon Water\",\n  \"id\" : 400,\n  \"image_title\" : \"mineral-water-lemon-lime\"\n}", Product.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Product>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Product>(this.productService.getProduct(productId),HttpStatus.OK);
    }

}
