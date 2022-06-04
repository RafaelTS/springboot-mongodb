package com.rafael.springmongodb.config;

import com.rafael.springmongodb.domain.Post;
import com.rafael.springmongodb.domain.User;
import com.rafael.springmongodb.dto.AuthorDTO;
import com.rafael.springmongodb.repository.PostRepository;
import com.rafael.springmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.CommandLineRunner;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configurable
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "vou viajar para SP, abracos", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "vou viajar para SP, abracos", new AuthorDTO(maria));

        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
