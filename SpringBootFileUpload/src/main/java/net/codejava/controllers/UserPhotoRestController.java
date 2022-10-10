package net.codejava.controllers;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RestController
public class UserPhotoRestController {
//
//    @GetMapping(value = "/users2-photos/{name}", consumes = "*/*", produces = "multipart/form-data")
//    public ResponseEntity<Resource> getFile(@PathVariable("name") String fileName) throws IOException {
//        File file = new File("/users2-photos/" + fileName);
//        Resource resource = new InputStreamResource(new FileInputStream(file));
//        return ResponseEntity.ok()
//                .contentLength(file.length())
//                .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                .body(resource);
//    }

    @GetMapping(value = "/users2-photos/{name}", consumes = "*/*", produces = "image/*")
    public byte[] getFile(@PathVariable("name") String fileName) throws IOException {
        File file = new File("/users2-photos/" + fileName);
        BufferedImage img = ImageIO.read(new FileInputStream(file));
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ImageIO.write(img, "jpg", bao);
        return bao.toByteArray();
    }

}
