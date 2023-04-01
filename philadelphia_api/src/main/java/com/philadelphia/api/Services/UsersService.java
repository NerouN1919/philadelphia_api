package com.philadelphia.api.Services;

import com.philadelphia.api.DAO.UsersDAO;
import com.philadelphia.api.DTO.IdDTO;
import com.philadelphia.api.DTO.LoginDTO;
import com.philadelphia.api.DTO.RegisterDTO;
import com.philadelphia.api.DTO.UserInfoDTO;
import com.philadelphia.api.Database.Users;
import com.philadelphia.api.Errors.Failed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.LinkOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UsersService {
    @Autowired
    private UsersDAO usersDAO;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public void registration(RegisterDTO registerDTO){
        List<Users> exists = usersDAO.getBylogin(registerDTO.getLogin());
        if(exists.size() != 0){
            throw new Failed("Exists this login");
        }
        usersDAO.addUser(registerDTO.getLogin(), passwordEncoder.encode(registerDTO.getPassword()),
                registerDTO.getName());
    }
    @Transactional(readOnly = true)
    public IdDTO login(LoginDTO loginDTO){
        List<Users> users = usersDAO.getBylogin(loginDTO.getLogin());
        if(users.size() == 0){
            throw new Failed("No such user");
        }
        Users user = users.get(0);
        if(!passwordEncoder.matches(loginDTO.getPassword(), user.getPassword())){
            throw new Failed("Bad password");
        }
        return new IdDTO(user.getId());
    }
    @Transactional(readOnly = true)
    public UserInfoDTO getInfo(Long id){
        List<Users> users = usersDAO.getById(id);
        if(users.size() == 0){
            throw new Failed("No such user");
        }
        Users user = users.get(0);
        return UserInfoDTO.builder().login(user.getLogin()).name(user.getName()).build();
    }
}
