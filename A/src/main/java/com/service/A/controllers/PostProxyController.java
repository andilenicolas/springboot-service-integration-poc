package com.service.A.controllers;

import lombok.RequiredArgsConstructor;
import com.service.b.clients.post.model.Post;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.service.b.clients.post.api.ServiceBPostClientApi;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequiredArgsConstructor
@RequestMapping("/proxy/posts")
public class PostProxyController {

    @Autowired
    private final ServiceBPostClientApi client;

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Integer id) {
        var result = client.postsIdGet(id);
        if (!result.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.notFound().build();
        }
        var bodyResult = result.getBody();
        return ResponseEntity.ok(bodyResult);
    }
}
