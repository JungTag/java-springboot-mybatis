package demo.mybatiscrud.controller;

import demo.mybatiscrud.mapper.UserProfileMapper;
import demo.mybatiscrud.model.UserProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserProfileController {

    private final UserProfileMapper mapper;

    @GetMapping("/user/{id}")
    public UserProfile getUserProfile(@PathVariable String id) {
        return mapper.getUserProfile(id);
    }

    @GetMapping("/user/all")
    public List<UserProfile> getUserProfileList() {
        return mapper.getUserProfileList();
    }

    @PostMapping("/user/{id}")
    public void createUserProfile(
            @PathVariable String id,
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam String address
    ) {
        mapper.insertUserProfile(id, name, phone, address);
    }

    @PutMapping("/user/{id}")
    public void putUserProfile(
            @PathVariable String id,
            @RequestParam String name,
            @RequestParam String phone,
            @RequestParam String address
    ) {
        mapper.updateUserProfile(id, name, phone, address);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserProfile(@PathVariable String id) {
        mapper.deleteUserProfile(id);
    }
}
