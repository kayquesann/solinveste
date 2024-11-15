package gs.solinveste.controller;

import gs.solinveste.dto.ReadUserDTO;
import gs.solinveste.dto.SaveUserDTO;
import gs.solinveste.model.User;
import gs.solinveste.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<SaveUserDTO> saveUser (@RequestBody @Valid SaveUserDTO userDTO) {
        SaveUserDTO newUser = userService.saveUser(userDTO);
        return ResponseEntity.ok(newUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("email/{id}")
    public ResponseEntity<ReadUserDTO> updateEmail (@PathVariable Integer id, @RequestBody String email) {
        ReadUserDTO user = userService.updateEmail(id, email);
        return ResponseEntity.ok(user);
    }

    @PutMapping("senha/{id}")
    public ResponseEntity<String> updatePassword (@PathVariable Integer id, @RequestBody String password) {
        String status = userService.updatePassword(id, password);
        return ResponseEntity.ok(status);
    }

    @GetMapping("{id}")
    public ResponseEntity<ReadUserDTO> readUser (@PathVariable Integer id) {
        ReadUserDTO user = userService.readUser(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<ReadUserDTO>> readUsers () {
        List<ReadUserDTO> users = userService.readUsers();
        return ResponseEntity.ok(users);
    }

}
