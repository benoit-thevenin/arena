package fr.phoenyx.arena.controllers;

import static fr.phoenyx.arena.constants.RestConstants.ROOT_USER;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(ROOT_USER)
    public Principal user(Principal principal) {
        return principal;
    }
}