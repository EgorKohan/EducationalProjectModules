package net.codejava.controllers;

import net.codejava.util.FileUploadUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users2")
public class UsersRestController {

    private final List<MultipartFile> files = new ArrayList<>();
    private final List<String> paths = new ArrayList<>();

    @GetMapping
    public List<String> getFiles() {
        return paths;
    }

    @PostMapping
    public void savePhoto(@RequestParam("photo") MultipartFile file) throws IOException {
        String name = file.getOriginalFilename();
        String uploadDir = "/users2-photos";
        FileUploadUtil.saveFile(uploadDir, name, file);
        paths.add(uploadDir + "/" + name);
    }

}
