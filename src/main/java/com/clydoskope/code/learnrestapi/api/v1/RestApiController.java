package com.clydoskope.code.learnrestapi.api.v1;


import com.clydoskope.code.spec.UserRequestEntity;
import com.clydoskope.code.spec.UserResponseEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@Api(value = "/api/v1/user", description = "Manage users")
public class RestApiController {



    @ApiOperation(value = "Get User details with a userId",response = UserResponseEntity.class)
    @ApiResponses({
            @ApiResponse(code = 404, message = "No User exist")
    })
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseEntity> getUser(@PathVariable String userId) {
        return new ResponseEntity<>(UserResponseEntity.builder().userId(userId).build(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get users", response = UserResponseEntity.class, responseContainer = "List")
    @ApiResponses({
            @ApiResponse(code = 404, message = "User does not exist.")
    })
    @GetMapping("/")
    public ResponseEntity<List<UserResponseEntity>> getUsers() {
        List<UserResponseEntity> users = new ArrayList<>();
        users.add(UserResponseEntity.builder().userId("adarsh").build());
        users.add(UserResponseEntity.builder().userId("clydoskope").build());

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @ApiOperation(value = "Create new user", response = UserResponseEntity.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "User is created successfully.")
    })
    @PostMapping("/")
    public ResponseEntity<UserResponseEntity> addUser(@RequestBody UserRequestEntity user) {
        System.out.println();

        return new ResponseEntity<>(UserResponseEntity.builder().userId(user.getUserId()).build(), HttpStatus.OK);
    }

    @ApiOperation(value = "Update User with userId", response = UserResponseEntity.class)
    @ApiResponses({
            @ApiResponse(code = 404, message = "User does not exist.")
    })
    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseEntity> updateUser(@PathVariable String userId, @RequestBody UserRequestEntity user) {
        System.out.println();

        return new ResponseEntity<>(UserResponseEntity.builder().userId(userId).build(), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete User with userId", response = UserResponseEntity.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "User is deleted successfully."),
            @ApiResponse(code = 404, message = "User does not exist.")
    })
    @DeleteMapping("/{userId}")
    public ResponseEntity<UserResponseEntity> delete(@PathVariable String userId) {
        return new ResponseEntity(UserResponseEntity.builder().userId(userId).build(), HttpStatus.OK);

    }
}
