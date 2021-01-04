package sn.simplon.senforage;

import javassist.bytecode.stackmap.BasicBlock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sn.simplon.senforage.dao.IRole;
import sn.simplon.senforage.dao.IUser;
import sn.simplon.senforage.entities.Role;
import sn.simplon.senforage.entities.User;

import javax.servlet.Filter;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SenforageApplication {



    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SenforageApplication.class, args);

        IUser iUser = ctx.getBean(IUser.class);

      /*  Role role = new Role();
        role.setId(1);
        role.setNom("ROLE_USER");

        IRole iRole = ctx.getBean(IRole.class);
        try {
            iRole.save(role);
            System.out.println("yes");
        }catch (Exception e){

        }*/
      /*  User user = new User();
        user.setId(1);
        user.setNom("Sow");
        user.setPrenom("Fama");
        user.setEmail("fama@simplon.co");
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode("passer"));
        user.setEtat(1);
        try {

            iUser.save(user);
            System.out.println("ok");

        } catch (Exception e){
            e.printStackTrace();

        }*/

    }

}
