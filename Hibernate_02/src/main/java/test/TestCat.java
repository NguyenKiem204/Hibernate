package test;

import dao.CatDAO;
import model.Cat;

import java.sql.Date;

public class TestCat {
    public static void main(String[] args) {
        CatDAO catDAO = new CatDAO();
//        -----------SelectAll---------------
//        List<Cat> listCat = catDAO.selectAll();
//        for (Cat cat : listCat) {
//            System.out.println(cat);
//        }
//        -----------SelectById-------------
//        Cat cat1 = new Cat();
//        cat1.setId(2);
//        Cat catFound = catDAO.selectById(cat1);
//        System.out.println(catFound);

//        --------------Insert----------------
        Cat cat2 = new Cat("Jerry", Date.valueOf("2023-08-20"), true);
        catDAO.insert(cat2);

//        -------------Update-----------------
//        Cat cat3 = new Cat("Mèo Mèo", Date.valueOf("2020-02-20"), false);
//        cat3.setId(1);
//        catDAO.update(cat3);

//        ------------Delete-----------------
//        Cat cat4 = new Cat();
//        cat4.setId(5);
//        catDAO.delete(cat4);
    }
}
