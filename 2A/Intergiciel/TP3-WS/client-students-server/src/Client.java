import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;

public class Client {
    public static void main(String[] args) {
        ResteasyClient client = new ResteasyClientBuilder().build();
        String baseUrl = "http://localhost:8080/students-server/rest";
        String getStudentUrl = baseUrl + "/getstudent";

        try {
            WebTarget target = client.target(getStudentUrl)
                                     .queryParam("firstname", "Alain")
                                     .queryParam("lastname", "Tchana");

            Response response = target.request().get();
            if (response.getStatus() == 200) {
                String body = response.readEntity(String.class);
                System.out.println("Response: " + body);
            }
        } finally {
            client.close();
        }
    }
}
