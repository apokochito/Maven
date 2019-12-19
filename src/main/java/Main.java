import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        // LOMBOK library
        Domain domain = new Domain();
        domain.setId(1L);
        domain.setName("John");
        domain.setJobDescription("Software Engineer");
        System.out.println("Property - Name: " + domain.getName() + "\nProperty - Job: " + domain.getJobDescription());

        // JACKSON library
        // Object into JSON - writeValue method - ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("target/domain.json"), domain);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // JSON as String value
        try {
            String json = objectMapper.writeValueAsString(domain);
            System.out.println("My json as string: " + json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // JSON String to a Java Object
        try {
            String json = "{\"id\":1, \"jobDescription\":\"Taxi Driver\", \"name\":\"Daniel\"}";
            Domain obj = objectMapper.readValue(json, Domain.class);
            System.out.println("Java object: "+obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // By URL to Java Object
        try {
            Domain json = objectMapper.readValue(new URL("file:src/main/resources/example.json"), Domain.class);
            System.out.println("Object from url: "+json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Java list from JSONArray
        try {
            String obj = "[{\"id\":2, \"jobDescription\":\"Actor\", \"name\":\"Will\"}, {\"id\":3, \"jobDescription\":\"Cook\", \"name\":\"Soph\"}]";
            List<Domain> domainList = objectMapper.readValue(String.valueOf(obj), new TypeReference<List<Domain>>() {
            });
            System.out.println("List: "+domainList);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Java Map from JSON String
        try {
            String obj = "{\"id\":5, \"jobDescription\":\"Engineer\", \"name\":\"Cory\"}";
            Map<String, Object> map = objectMapper.readValue(obj, new TypeReference<Map<String, Object>>() {
            });
            System.out.println("Map: "+map);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // Orika Library
        // Factory Object
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(Backend.class, Frontend.class);
        MapperFacade mapper = mapperFactory.getMapperFacade();
        Backend toService = new Backend("This is a property from backend", 10);
        Frontend toClient = mapper.map(toService, Frontend.class);
        System.out.println("Object mapped: "+toClient);

        //
    }
}
