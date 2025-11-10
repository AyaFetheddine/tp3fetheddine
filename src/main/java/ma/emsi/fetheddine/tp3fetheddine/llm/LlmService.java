package ma.emsi.fetheddine.tp3fetheddine.llm;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class LlmService {

    @Produces
    @ApplicationScoped
    public GuideTouristique createGuideTouristique() {


        String apiKey = System.getenv("GEMINI_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException(
                    "Erreur : variable d'environnement GEMINI_KEY absente ou vide."
            );
        }


        ChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(apiKey)
                .modelName("gemini-2.5-flash")
                .temperature(0.7)
                .build();


        return AiServices.builder(GuideTouristique.class)
                .chatModel(model)
                .build();
    }
}