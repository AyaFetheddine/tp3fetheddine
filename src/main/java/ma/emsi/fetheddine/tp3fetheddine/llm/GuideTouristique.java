package ma.emsi.fetheddine.tp3fetheddine.llm;


import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;


public interface GuideTouristique {

    @SystemMessage("""
        Tu es un guide touristique expert. Tu réponds à l'utilisateur en français.
        Tu dois fournir le nombre demandé d'endroits principaux à visiter pour le lieu donné,
        ainsi que le prix moyen d'un repas dans la devise locale.

        Tu DOIS répondre UNIQUEMENT au format JSON suivant, sans aucun texte avant ou après,
        et SANS utiliser le formatage Markdown.

        {
          "ville_ou_pays": "nom du lieu",
          "endroits_a_visiter": ["endroit 1", "endroit 2", ...],
          "prix_moyen_repas": "<prix> <devise>"
        }
        """)
        // Utiliser le templating pour passer les deux variables
    String genererInfosTouristiques(
            @UserMessage(value = "Donne-moi les infos pour {{villeOuPays}} en listant {{nombre}} endroits.")
            String villeOuPays,
            int nombre
    );
}