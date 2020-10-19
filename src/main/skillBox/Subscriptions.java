import javax.persistence.*;
import java.util.Date;

/**
 * @author Musa Dzhabirov
 */

@Entity
@Table(name = "Subscriptions")
public class Subscriptions {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int ID;

    @Column(name = "student_id")
    private int studentId;

    @Column(name = "course_id")
    private int courseId;

    @Column(name = "subscription_date")
    private Date subscriptionData;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Date getSubscriptionData() {
        return subscriptionData;
    }

    public void setSubscriptionData(Date subscriptionData) {
        this.subscriptionData = subscriptionData;
    }
}
