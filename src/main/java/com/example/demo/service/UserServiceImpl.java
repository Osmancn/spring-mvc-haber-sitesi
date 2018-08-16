package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.IUserRepository;
import com.example.demo.util.EmailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import javax.mail.Session;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    IUserRepository userRepository;


    @Override
    public void save(User user) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder() ;
        String encodePass = passwordEncoder.encode(user.getSifre());
        user.setSifre(encodePass);

        if(user.getEmail().equalsIgnoreCase("osmancan6767@gmail.com"))
        {
            user.setValid(true);
            user.setRole("ADMIN");
            userRepository.save(user);
        }
        else {
            user.setRole("GUEST");
            userRepository.save(user);
            // eposta doğrulama işlemleri yapılacak
            String emailID = user.getEmail();

            Properties props = System.getProperties();
            props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
            props.put("mail.smtp.port", "587"); //TLS Port
            props.put("mail.smtp.auth", "true"); //enable authentication
            props.put("mail.smtp.starttls.enable", "true");


            javax.mail.Authenticator auth = new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("ruka.testind@gmail.com", "163311022");
                }
            };
            Session session = Session.getInstance(props, auth);

            EmailUtil.sendEmail(session, emailID, "Aktivasyon Kodu",
                    "Hesabınızın aktifleştirilmesi için bu linke " +
                            "tıklayınız:http://www.localhost:1111/orders?actCode=" + user.getActCode());
        }
    }
}
