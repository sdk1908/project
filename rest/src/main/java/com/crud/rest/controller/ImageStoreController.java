package com.crud.rest.controller;

import com.crud.rest.entity.Image;
import com.crud.rest.entity.Response;
import com.crud.rest.repositroy.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("/api/images")
public class ImageStoreController {

    @Autowired
    ImageRepository imageRepository;

    @PostMapping
    public ResponseEntity<Response<Image>> saveImage(@RequestParam("file") MultipartFile file) throws Exception {
            Image image = new Image();
            image.setName(file.getName());
            image.setData(file.getBytes());
            imageRepository.save(image);

            Response response = new Response("Image store Successfully",image);
            return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getImage(@PathVariable("id") Long id){
        Optional<Image> image = Optional.ofNullable(imageRepository.findById(id)).orElse(null);
                   if(image == null){
                       return ResponseEntity.status(404).body("Image Not found");
                   }
                   else {
                       Response response = new Response("Image Retrived Successfully", image);
                       return new ResponseEntity<>(response, HttpStatus.OK);
                   }
    }

    @GetMapping(value="/display/image/{id}",produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<?> displayImageOnBrowser(@PathVariable Long id){
        Image image = imageRepository.findById(id).orElse(null);
        if(image == null)
            return ResponseEntity.status(404).body("Image not found");
        else
            return new ResponseEntity<>(image.getData(),HttpStatus.OK);
    }

}
