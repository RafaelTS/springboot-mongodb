package com.rafael.springmongodb.services;

import com.rafael.springmongodb.domain.Post;
import com.rafael.springmongodb.exception.ObjectNotFoundException;
import com.rafael.springmongodb.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<Post> findByTitle (String text){
        return repo.findByTitleContainingIgnoreCase(text);
    }
}