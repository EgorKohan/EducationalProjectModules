package net.codejava.controllers;

import lombok.extern.slf4j.Slf4j;
import net.codejava.models.User;
import net.codejava.util.FileUploadUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/users")
public class UserController {

    private final List<User> users = new ArrayList<>();

    @GetMapping()
    private String getIndex(Model model) {
        if (!users.isEmpty()) model.addAttribute("user", users.get(0));
        return "index";
    }

    @PostMapping
    public RedirectView save(@ModelAttribute User user, @RequestParam("photo") MultipartFile file) throws IOException {
        String originalFilename = StringUtils.cleanPath(file.getOriginalFilename());
//        User user2 = new User(name, originalFilename);
//
//        users.add(user2);

//        String uploadDir = "user2-photos/" + user2.getName();
//        FileUploadUtil.saveFile(uploadDir, originalFilename, file);

        return new RedirectView("/users");
    }

}
