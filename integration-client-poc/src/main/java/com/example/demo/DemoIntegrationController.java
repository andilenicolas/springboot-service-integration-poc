package com.example.demo;

import com.example.integrations.jsonplaceholder.post.model.Post;
import com.example.integrations.jsonplaceholder.comments.model.Comment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/demo/jsonplaceholder")
public class DemoIntegrationController {

    private final com.example.integrations.jsonplaceholder.post.DefaultApiClient postClient;
    private final com.example.integrations.jsonplaceholder.comments.DefaultApiClient commentsClient;

    public DemoIntegrationController(
            com.example.integrations.jsonplaceholder.post.DefaultApiClient postClient,
            com.example.integrations.jsonplaceholder.comments.DefaultApiClient commentsClient) {
        this.postClient = postClient;
        this.commentsClient = commentsClient;
    }

    @GetMapping("/posts/{id}")
    public Post getPost(@PathVariable Integer id) {
        ResponseEntity<Post> result = postClient.getPostById(id);
        return result.getBody();
    }

    @GetMapping("/posts/{id}/comments")
    public List<Comment> getComments(@PathVariable Integer id) {
        ResponseEntity<List<Comment>> result = commentsClient.getCommentsByPostId(id);
        return result.getBody();
    }
}
