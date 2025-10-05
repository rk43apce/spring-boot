package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.concurrent.ThreadLocalRandom;

import java.util.List;
import java.util.Map;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@RestController
public class HelloController {

    @Autowired
    private GreetingRepository greetingRepository;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/")
    public String home() {
        return "Welcome! 🎉 You are logged in";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Spring  !";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "Hello, Spring Boot is running!";
    }

    @GetMapping("/greetings")
    public List<Map<String, Object>> getGreetings() {
        return greetingRepository.findAllRaw();
    }

    @GetMapping("/external-todo")
    public Object getExternalTodo() {
        String url = "https://jsonplaceholder.typicode.com/todos";
        return restTemplate.getForObject(url, Object.class);
    }

    @GetMapping("/external-posts")
    public Object getExternalPosts() {
        try {


            HttpClient client = HttpClient.newBuilder().build();

            int randomId = ThreadLocalRandom.current().nextInt(1, 101);

            String url = "https://jsonplaceholder.typicode.com/posts/" + randomId;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            // 3️⃣ Send request synchronously
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }


    public static String fetch(String url) throws Exception {
        HttpClient client = HttpClient.newHttpClient(); // simple client
        HttpRequest request = HttpRequest.newBuilder(URI.create(url)).build(); // simple GET
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
