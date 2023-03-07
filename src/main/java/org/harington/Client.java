package org.harington;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@XmlRootElement
@NoArgsConstructor

public class Client implements Serializable{
    private String name;
    private String secname;
    private String phone;
    private String email;
    private Date dateNaissance;
}
