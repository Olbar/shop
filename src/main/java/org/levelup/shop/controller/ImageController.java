//package org.levelup.shop.controller;
//
//import lombok.SneakyThrows;
//import org.levelup.shop.domain.dto.FileAsString;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.BufferedOutputStream;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//import java.util.Base64;
//
//@Controller
//@RequestMapping("/image")
//public class ImageController {
//    @Value("${shop.attachments}")
//
//    private String attachmentDirectoryPath;
//
//
//    @SneakyThrows
//    @ResponseBody
//    @PostMapping("/file")
//    public void loadImageAsFile(@RequestParam("image") MultipartFile file) {
//        Path path = Files.createFile( Paths.get(attachmentDirectoryPath + file.getOriginalFilename()));
//        file.transferTo(path);
//    }
//
//    @ResponseBody
//    @PostMapping("/string")
//    public void loadImageAsString(@RequestBody FileAsString fileAsString) throws IOException {
//        byte[] bytes = Base64.getDecoder().decode(fileAsString.getFile());
//        File file = new File(attachmentDirectoryPath + fileAsString.getFilename());
//
//        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(file))) {
//            outputStream.write(bytes);
//            outputStream.flush();
//        }
//
//    }
//    @GetMapping
//    public String displayPage() {
//        return "image";
//    }
//}
