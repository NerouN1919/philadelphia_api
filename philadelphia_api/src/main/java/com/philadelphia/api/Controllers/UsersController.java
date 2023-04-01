package com.philadelphia.api.Controllers;

import com.philadelphia.api.DTO.IdDTO;
import com.philadelphia.api.DTO.LoginDTO;
import com.philadelphia.api.DTO.RegisterDTO;
import com.philadelphia.api.DTO.UserInfoDTO;
import com.philadelphia.api.Services.UsersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/users")
@PreAuthorize("hasAuthority('ADMIN')")
@Tag(name = "Controller for users")
public class UsersController {
    @Autowired
    private UsersService usersService;
    @PostMapping
    @Operation(summary = "Registartion user")
    public void registration(@RequestBody RegisterDTO registerDTO){
        usersService.registration(registerDTO);
    }
    @PostMapping("login")
    @Operation(summary = "Login user into account")
    public IdDTO login(@RequestBody LoginDTO loginDTO){
        return usersService.login(loginDTO);
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get info by user id")
    public UserInfoDTO getInfo(@PathVariable("id") Long id){
        return usersService.getInfo(id);
    }
}
