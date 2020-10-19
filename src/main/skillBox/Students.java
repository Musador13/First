import javax.persistence.*;
import java.util.Date;

/**
 * @author Musa Dzhabirov
 */

@Entity
@Table(name = "Students")
public class Students {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int ID;

    private String name;

    private int age;

    @Column(name = "registration_date")
    private Date registrationDate;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegistration_date() {
        return registrationDate;
    }

    public void setRegistration_date(Date registration_date) {
        this.registrationDate = registration_date;
    }
}
