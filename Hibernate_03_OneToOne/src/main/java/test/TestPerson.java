package test;

import dao.PersonDAO;
import model.Person;
import until.HibernateUntil;

import java.util.ArrayList;
import java.util.List;

public class TestPerson {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();
//        Person person1 = personDAO.selectById(1);
//        System.out.println(person1);
//        Person person2 = new Person("Nguyễn Văn Thanh", person1);
//        System.out.println(person2);
//        personDAO.insert(person2);

//        Person person3 = new Person("Nguyễn Văn Nam", new PersonDAO().selectById(2));
//        person3.setId(3);
//        personDAO.update(person3);

        List<Person> listPerson;
        listPerson = personDAO.selectAll();
        for (Person person : listPerson) {
//            condition ? value_if_true : value_if_false;
            String spouseInfo = (person.getSpouse() != null) ?
                    person.getSpouse().getName() + " (" + person.getSpouse().getId() + ")" :
                    "Chưa kết hôn";

            System.out.println(person.getName() + "(" + person.getId() + ")" + " đã kết hôn với " + spouseInfo);

        }

        HibernateUntil.shutdown();
    }

}
