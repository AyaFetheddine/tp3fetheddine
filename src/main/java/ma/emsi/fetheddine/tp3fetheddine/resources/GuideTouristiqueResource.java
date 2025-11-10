package ma.emsi.fetheddine.tp3fetheddine.resources;


import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/guide")
public class GuideTouristiqueResource {

    @GET
    @Path("lieu/{ville_ou_pays}")
    // On spécifie qu'on produit du JSON
    @Produces(MediaType.APPLICATION_JSON)
    public String[] getInfosTouristiquesTest(@PathParam("ville_ou_pays") String villeOuPays) {

        // Test demandé : retourner un tableau de String
        return new String[]{villeOuPays, "test"};
    }
}