package test;

import dao.CustomerDAO;
import dao.OrderDAO;
import model.Customer;
import model.My_Order;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        CustomerDAO customerDAO = new CustomerDAO();
        OrderDAO orderDAO = new OrderDAO();

//        --------------Insert---------------------
        Customer customer1 = new Customer("CUS1", "Nguyễn Văn Kiểm");
        Customer customer2 = new Customer("CUS2", "Lê Thanh Hải");
//
        My_Order order1 = new My_Order("OD1", "Hà Nội", customer1);
        My_Order order2 = new My_Order("OD2", "Nghệ An", customer1);
        My_Order order3 = new My_Order("OD3", "Hải Phòng", customer1);
        My_Order order4 = new My_Order("OD4", "Sài Gòn", customer1);

        List<My_Order> listOrder = new ArrayList<>();
        listOrder.add(order1);
        listOrder.add(order2);
        listOrder.add(order3);
        listOrder.add(order4);
        customer1.setOrders(listOrder);

        customerDAO.insert(customer1);
        customerDAO.insert(customer2);

        orderDAO.insert(order1);
        orderDAO.insert(order2);
        orderDAO.insert(order3);
        orderDAO.insert(order4);

    }
}
