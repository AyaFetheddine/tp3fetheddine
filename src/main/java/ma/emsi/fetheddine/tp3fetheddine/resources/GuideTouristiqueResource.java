package ma.emsi.fetheddine.tp3fetheddine.resources;



import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ma.emsi.fetheddine.tp3fetheddine.llm.GuideTouristique;

@Path("/guide")
public class GuideTouristiqueResource {

    // 1. INJECTER L'INTERFACE DIRECTEMENT
    @Inject
    private GuideTouristique guide;

    @GET
    @Path("lieu/{ville_ou_pays}/{nombre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInfosTouristiquesAvecNombre(
            @PathParam("ville_ou_pays") String villeOuPays,
            @PathParam("nombre") int nombre) {

        try {
            // 2. APPELER L'INTERFACE DIRECTEMENT
            String reponseJson = guide.genererInfosTouristiques(villeOuPays);
            return Response.ok(reponseJson).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erreur lors de la communication avec le LLM.")
                    .build();
        }
    }

    @GET
    @Path("lieu/{ville_ou_pays}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInfosTouristiques(@PathParam("ville_ou_pays") String villeOuPays) {
        return getInfosTouristiquesAvecNombre(villeOuPays, 2);
    }
}