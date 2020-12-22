package JaxbTask;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbHandler {
    public void convertObjectToXml(Planet planet, String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Planet.class);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            marshaller.marshal(planet, new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public Planet fromXmlToObject(String filePath) {
        try {
            JAXBContext context = JAXBContext.newInstance(Planet.class);

            Unmarshaller unmarshaller = context.createUnmarshaller();

            return (Planet) unmarshaller.unmarshal(new File(filePath));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
