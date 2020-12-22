package JaxbTask;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class Planet {

    private String planetName;
    private List<State> states;

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public List<State> getStates() {
        return states;
    }

    @XmlElementWrapper(name = "states")
    @XmlElement(name = "state")
    public void setStates(List<State> states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "planetName='" + planetName + '\'' +
                ", states=" + states +
                '}';
    }
}
