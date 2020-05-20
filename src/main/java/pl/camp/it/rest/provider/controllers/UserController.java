package pl.camp.it.rest.provider.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.camp.it.rest.provider.model.Request;
import pl.camp.it.rest.provider.model.ResponseMessage;
import pl.camp.it.rest.provider.model.User;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<ResponseMessage<User>> getUser() {
        User user = new User();
        user.setLogin("Mateusz");
        user.setPass("tajneHaslo");

        ResponseMessage<User> response = new ResponseMessage<>();
        response.setContent(user);
        response.setStatusCode(200);
        response.setMessage("OK");

        ResponseEntity<ResponseMessage<User>> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);

        return responseEntity;
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.POST)
    public ResponseMessage<List<User>> getUsers(@RequestBody Request request) {
        System.out.println(request.getParam());

        List<User> users = new ArrayList<>();

        User u1 = new User();
        u1.setPass("abc");
        u1.setLogin("abc");

        User u2 = new User();
        u2.setLogin("qwe");
        u2.setPass("qwe");

        users.add(u1);
        users.add(u2);

        ResponseMessage<List<User>> response = new ResponseMessage<>();
        response.setContent(users);
        response.setStatusCode(200);
        response.setMessage("OK");

        return response;
    }

    @RequestMapping(value = "/getAllLogins", method = RequestMethod.GET)
    public ResponseMessage<List<String>> getAllLogins() {
        List<String> list = new ArrayList<>();

        list.add("mateusz");
        list.add("janusz");
        list.add("michał");
        list.add("wiesiek");

        ResponseMessage<List<String>> response = new ResponseMessage<>();

        response.setContent(list);
        response.setStatusCode(200);
        response.setMessage("OK");

        return response;
    }

    @RequestMapping(value = "/getUserWithHeaders", method = RequestMethod.GET)
    public User getUserWithHeaders(@RequestHeader("login-header-cos-tam") String login) {
        System.out.println(login);

        return new User();
    }

    @RequestMapping(value = "/getUser2", method = RequestMethod.GET)
    public User getUserWithHeaders() {
        User user = new User();
        user.setPass("kasjygdf");
        user.setLogin("hasgfd");
        return user;
    }
}
