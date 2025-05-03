package com.bookstoreAI.features.getactivity.service;


import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class OpenAIService implements IOpenAIService {

    private final OpenAiChatModel openAiChatModel;


    public OpenAIService(OpenAiChatModel openAiChatModel) {
        this.openAiChatModel = openAiChatModel;
    }

    public String bookstoreReview (String book) {

        PromptTemplate promptTemplate = new PromptTemplate("""
                Por favor, me forneça um breve resumo do livro {book}
                e também a biografia do seu autor.
                """);

        promptTemplate.add("book", book);

        return this.openAiChatModel.call(promptTemplate.create()).getResult().getOutput().getText();

    }

    public String bookstoreChat (String message) {
        return openAiChatModel.call(message);
    }

    public Flux<String> bookstoreChatStream(String message) {
        return openAiChatModel.stream(message);
    }

}
