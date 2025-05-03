package com.bookstoreAI.features.getactivity.service;


import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


public interface IOpenAIService  {

    String bookstoreReview(String book);

    String bookstoreChat(String message);

    Flux<String> bookstoreChatStream(String message);
}
