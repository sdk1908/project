package com.practice.learn.controller;

import com.practice.learn.entity.PostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RestControllerForEntity {

   // private final RestTemplate restTemplate = new RestTemplate();
    @Autowired
    RestTemplate restTemplate;


    @GetMapping("/get")
    public String getForEntity() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        ResponseEntity<String> getReturn = restTemplate.getForEntity(url, String.class);

        return getReturn.getBody();
    }

    @GetMapping("/getForObject")
    public PostEntity getForObject() {
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        PostEntity getReturn = restTemplate.getForObject(url, PostEntity.class);

        return getReturn;
    }

    @PostMapping("/postForObject")
    public String postForObject(@RequestBody PostEntity pe)
    {   //PostEntity pe = new PostEntity(7000,"tst","i am a tester",444);
        String url = "https://jsonplaceholder.typicode.com/posts";
        String getReturn ="";
        try{
            getReturn = restTemplate.postForObject(url,pe,String.class);
        }
        catch (Exception e)
        {
                ResponseEntity.internalServerError().build();
        }
        return getReturn;
    }

    @PostMapping("/exchangePost")
    public ResponseEntity<String> exchange(@RequestBody PostEntity pe){
        ResponseEntity<String> response=null;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("auth","xyz");
        HttpEntity<PostEntity> reqEntity=new HttpEntity<>(pe,headers);
        String url = "https://jsonplaceholder.typicode.com/posts";
        try {
            response = restTemplate.exchange(url, HttpMethod.POST, reqEntity, String.class);
        }
        catch(Throwable t){
          return  ResponseEntity.internalServerError().build();
        }
        return response;
    }

    @GetMapping("/streamApi")
    public ResponseEntity<String> streamApi(){
        ResponseEntity<streamApi> response=null;
        List<Integer> list= Arrays.asList(10,20,2,1,7);
        list.stream().sorted((s1,s2)->s1<s2?-1:s1>s2?1:0).collect(Collectors.toList()).forEach(System.out::println);

        try {
            response = restTemplate.exchange(url, HttpMethod.POST, reqEntity, String.class);
        }
        catch(Throwable t){
            return  ResponseEntity.internalServerError().build();
        }
        return response;
    }
}
