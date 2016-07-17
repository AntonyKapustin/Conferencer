package me.conferencer.rest;

import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Kapustin Anton anton@kapustin.me
 */
@Api(value = "/greeting", description = "Very cool and good greeting logic, attempt to test Swagger!")
@RestController
public class RestTest {

    @ApiOperation(value = "Returns name concatenated with 'Hello'.", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of string.", response = String.class),
            @ApiResponse(code = 404, message = "If something bad happens.")}
    )
    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greeting(
            @ApiParam(name = "userName", value = "Alphanumeric login to the application", required = true)
            @RequestParam(value="name", defaultValue="World")
                    String name) {
        return "Hello " + name;
    }

}
