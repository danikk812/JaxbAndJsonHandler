package JaxbTask;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String FILE_XML = "jaxb.xml";
    private static final String FILE_JSON = "testJSON.json";

    public static void main(String[] args) throws JsonProcessingException {
        User user1 = new User();
        user1.setSex("man");
        user1.setAge(20);

        User user2 = new User();
        user2.setSex("woman");
        user2.setAge(30);

        List<User> userList = new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);

        City cityBel1 = new City();
        cityBel1.setCityName("Minsk");
        cityBel1.setUsers(userList);

        City cityBel2 = new City();
        cityBel2.setCityName("Vitebsk");
        cityBel2.setUsers(userList);

        City cityUa1 = new City();
        cityUa1.setCityName("Kiev");
        cityUa1.setUsers(userList);

        City cityUa2 = new City();
        cityUa2.setCityName("L'vov");
        cityUa2.setUsers(userList);

        List<City> cityListBel = new ArrayList<City>();
        cityListBel.add(cityBel1);
        cityListBel.add(cityBel2);

        List<City> cityListUa = new ArrayList<City>();
        cityListUa.add(cityUa1);
        cityListUa.add(cityUa2);


        State bel = new State();
        bel.setStateName("Belarus");
        bel.setCities(cityListBel);

        State ua = new State();
        ua.setStateName("Ukraine");
        ua.setCities(cityListUa);

        List<State> stateList = new ArrayList<State>();
        stateList.add(bel);
        stateList.add(ua);

        Planet planet = new Planet();
        planet.setPlanetName("Earth");
        planet.setStates(stateList);

        JaxbHandler jaxbHandler = new JaxbHandler();

        jaxbHandler.convertObjectToXml(planet, FILE_XML);

        Planet unmarshalPlanet = jaxbHandler.fromXmlToObject(FILE_XML);
        if (unmarshalPlanet != null) {
            System.out.println(unmarshalPlanet);
        }

        JsonHandler jsonHandler = new JsonHandler();

        jsonHandler.convertObjectToJSON(planet,FILE_JSON);

        Planet fromJsonPlanet = jsonHandler.fromJSONToObject(FILE_JSON);
        if (fromJsonPlanet != null) {
            ObjectMapper mapper = new ObjectMapper();
            String prettyString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(fromJsonPlanet);
            System.out.println(prettyString);
        }

    }
}
