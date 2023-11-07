package com.uniteam.flashmemorizer.controller;
import com.uniteam.flashmemorizer.dto.UserDTO;
import com.uniteam.flashmemorizer.record.LoginRequest;
import com.uniteam.flashmemorizer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.logging.Logger;

@Controller
@RequiredArgsConstructor
@RequestMapping("/login-process")
public class LoginController{
    @Autowired
    private final UserService userService;

    @PostMapping
    public String login(@org.jetbrains.annotations.NotNull @ModelAttribute("user") LoginRequest user){

        Logger logger = Logger.getLogger(LoginController.class.getName());
        logger.info("User: "+ user);

        UserDTO oauthUser = userService.loginUser(user);

        if(Objects.isNull(oauthUser))
            return "redirect:/home?loginFailed";

        return "redirect:/decks/get-my-decks/" + oauthUser.getId();
    }

}