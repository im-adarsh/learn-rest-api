package com.clydoskope.code.learnrestapi.api.v1;


import com.clydoskope.code.spec.UserRequestEntity;
import com.clydoskope.code.spec.UserResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.ws.rs.Path;

@RestController
@RequestMapping( "/api/v1/user/" )
@Api( value = "/api/v1/user/", description = "Manage users" )
public class RestApiController {



    @ApiOperation(value = "Get User details with a userId",response = UserResponseEntity.class)
    @ApiResponses( {@ApiResponse( code = 404, message = "Person with such userId doesn't exists" )} )
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET)
    public UserResponseEntity getUser(@PathVariable String userId){
        return UserResponseEntity.builder().userId(userId).build();
    }

    @ApiOperation(value = "Update User with user id",response = UserResponseEntity.class)
    @RequestMapping(value = "/{userId}", method = RequestMethod.POST)
    @ResponseBody
    public UserResponseEntity updateUser(@PathVariable String userId, @RequestBody UserRequestEntity user){
        System.out.println();

        return UserResponseEntity.builder().userId(userId).build();
    }
}
