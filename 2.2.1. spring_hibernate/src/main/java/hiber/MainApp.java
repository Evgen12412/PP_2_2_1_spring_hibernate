package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      User user1 = new User("User1","Lastname1", "user1@mail.ru");
      userService.add(user1);
      Car car1 = new Car("Volga", 21);
      carService.add(car1);
      user1.setCar(car1);
      car1.setUser(user1);


      User user2 = new User("User2","Lastname2", "user2@mail.ru");
      userService.add(user2);
      Car car2 = new Car("Vaz", 2106);
      user2.setCar(car2);
      car2.setUser(user2);

      User user3 = new User("User3","Lastname3", "user3@mail.ru");
      userService.add(user3);
      Car car3 = new Car("Gaz", 21);
      user3.setCar(car3);
      car3.setUser(user3);


      User user4 = new User("User4","Lastname4", "user4@mail.ru");
      userService.add(user4);
      Car car4 = new Car("Vaz", 2109);
      user4.setCar(car4);
      car4.setUser(user4);





      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
//      System.out.println(carService.getUserAndCar("Vaz", 2109).toString());
      context.close();
   }
}
