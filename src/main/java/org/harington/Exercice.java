package org.harington;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.text.ParseException;
import java.util.List;

import static org.harington.CsvToJsonXmlConverter.*;
public class Exercice {
    static void converter(String path, String type) throws IOException, ParseException, JAXBException {
        List<Client> clients=readFile(path);
        if(type.equals("Json")){
            ConvertJson(path);
        }

            ConvertXML(path);


}
    public static void main(String[] args) throws JAXBException, IOException, ParseException {
        String csvPath="C:\\Users\\hadda\\Desktop\\exercice\\src\\main\\java\\org\\harington\\clients.csv";
        converter(csvPath,"Json");
    }
}
