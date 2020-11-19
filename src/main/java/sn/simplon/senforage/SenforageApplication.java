package sn.simplon.senforage;

import javassist.bytecode.stackmap.BasicBlock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import sn.simplon.senforage.dao.IRole;
import sn.simplon.senforage.dao.IUser;
import sn.simplon.senforage.entities.Role;
import sn.simplon.senforage.entities.User;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SenforageApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SenforageApplication.class, args);
       /*
       ------------------------
        IUser iUser = ctx.getBean(IUser.class);

        Role role = new Role();
        role.setId(1);
        role.setNom("ROLE_USER");

        User user = new User();
        user.setId(1);
        user.setNom("Ba");
        user.setPrenom("Aissata");
        user.setEmail("aissata@simplon.co");
        user.setPassword("passer");
        user.setEtat(1);
        try {

            iUser.save(user);
            System.out.println("ok");

        } catch (Exception e){
            e.printStackTrace();

        }

-------------------------
*/





       /* List<User> users = new ArrayList<User>();
        users.add(user);
        role.setUsers(users);

        IRole iRole = ctx.getBean(IRole.class);
        try {
            iRole.save(role);
            System.out.println("yes");
        }catch (Exception e){

        }*/







       /* User user = new User();
        user.setId(1);
        user.setNom("Ba");
        user.setPrenom("Aissata");
        user.setEmail("aissata@simplon.co");
        user.setPassword("passer");
        user.setEtat(1);

        try {

            iUser.save(user);
            System.out.println("ok");

        } catch (Exception e){
            e.printStackTrace();

        }*/
    }

}
