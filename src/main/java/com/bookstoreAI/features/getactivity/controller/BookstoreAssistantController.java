package com.bookstoreAI.features.getactivity.controller;

import com.bookstoreAI.features.getactivity.service.IOpenAIService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/bookstore")
public class BookstoreAssistantController {

    private final IOpenAIService service;

    public BookstoreAssistantController(IOpenAIService service) {
        this.service = service;
    }


    @GetMapping("/informations")
    public String bookstoreChat(@RequestParam(value = "message",
            defaultValue = "Quais são os 5 livros best sellers dos ultimos anos?") String message) {

        return service.bookstoreChat(message);

    }

    @GetMapping("/reviews")
    public String bookstoreReview (@RequestParam(value = "book", defaultValue = "Dom Quixote") String book) {

        return service.bookstoreReview(book);

    }

    @GetMapping("/stream/informations")
    public Flux<String> bookstoreChatStream(@RequestParam(value = "message",
            defaultValue = "Quais são os 5 livros best sellers dos ultimos anos?") String message) {

        return service.bookstoreChatStream(message);

    }

}
