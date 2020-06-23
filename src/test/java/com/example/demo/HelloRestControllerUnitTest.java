package com.example.demo;

import com.example.demo.entities.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.runner.RunWith;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloRestControllerUnitTest {

    @Autowired
    private TestRestTemplate template;

    @Test
    public void greetWithoutName() {
        ResponseEntity<Greeting> entity = template.getForEntity("/rest", Greeting.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals(MediaType.APPLICATION_JSON, entity.getHeaders().getContentType());
        Greeting response = entity.getBody();
        assertEquals("Hello, World!", response.getMessage());
    }

    @Test
    public void greetWithName() {
        Greeting response = template.getForObject("/rest?name=Dolly", Greeting.class);
        assertEquals("Hello, Dolly!", response.getMessage());
    }


    // my first try not work
//    @Test
//    public void sayGreeting(){
//        HelloRestController controller = new HelloRestController();
//        Model model = new BindingAwareModelMap();
//        Greeting result = controller.greet("World");
//        Greeting greet = new Greeting(String.format("Hello, $%!", "World"));
//        assertEquals(greet,result);
//    }
}
