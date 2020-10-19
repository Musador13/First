import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.sql.*;
/**
 * @author Musa Dzhabirov
 */
public class SkillBox {

    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        /*Course course = session.get(Course.class, 2);
        System.out.println(course.getClass());*/

        PurchaseList pL = session.get(PurchaseList.class, 1);
        System.out.println(pL.getCourseName());

        Students students = session.get(Students.class,12);
        System.out.println(students.getAge());

        Subscriptions subscriptions = session.get(Subscriptions.class,11);
        System.out.println(subscriptions.getStudentId());

        Teachers teachers = session.get(Teachers.class,22);
        System.out.println(teachers.getSalary());

        sessionFactory.close();
    }
}
