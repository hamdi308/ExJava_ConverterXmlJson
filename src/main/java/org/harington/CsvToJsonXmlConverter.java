package org.harington;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CsvToJsonXmlConverter {
    public static List<Client> readFile(String path) throws IOException, ParseException {
        BufferedReader br = null;
        String line = "";
        String csvSplitBy = ";";
        List<Client> clients = new ArrayList<>();

        br = new BufferedReader(new FileReader(path));
        while ((line = br.readLine()) != null) {
            String[] clientData = line.split(csvSplitBy);
            String name = clientData[0];
            String secname = clientData[1];
            String phone = clientData[2];
            String email = clientData[3];
            String dateString = clientData[4];
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date dateNaissance = dateFormat.parse(dateString);
            clients.add(new Client(name, secname, phone, email, dateNaissance));
        }
        return clients;
    }
    public static Gson ConvertJson(String path) throws IOException, ParseException {
            List<Client> clients=readFile(path);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter writer = new FileWriter("clients.json");
            gson.toJson(clients, writer);
            writer.flush();
            writer.close();
            return gson;
    }
    public static void ConvertXML(String path) throws JAXBException, IOException, ParseException {
            List<Client> clients=readFile(path);
            JAXBContext jaxbContext = JAXBContext.newInstance(Clients.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Clients clientsXml = new Clients();
            clientsXml.setClients(clients);
            marshaller.marshal(clientsXml, new FileWriter("clients.xml"));
    }
}
