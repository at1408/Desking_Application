package com.team17.desking;

import java.io.IOException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;

import com.team17.desking.entity.User;
import com.team17.desking.repository.BookingRepository;

@SpringBootApplication
public class DeskingApplication {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private BookingRepository bookrepo;

    public static void main(String[] args) {
        SpringApplication.run(DeskingApplication.class, args);
    }

    @Bean
    public CommandLineRunner runner() {
        return new CommandLineRunner() {


            //@Scheduled(cron = "0 18 * * * *")
            @Scheduled(fixedDelay = 43200000)
            @Override
            public void run(String... args) throws Exception {
                // TODO Auto-generated method stub

                Timer timer = new Timer();
                TimerTask task = new TimerTask() {
                    @Override
                    public void run() {
                        System.out.println("Sending Email...");
                        SimpleMailMessage msg = new SimpleMailMessage();
                        List<User> users = bookrepo.getUsers();
                        for (int i = 0; i < users.size(); i++) {
                            msg.setTo(users.get(i).getEmail());
                            msg.setFrom("project17team@gmail.com");
                            msg.setSubject("Reminder on upcoming desk booking");
                            msg.setText("Hi "+users.get(i).getfName()+", \n We look forward to welcome you at your office. \n best regards,\n Social Desking Team17");
                            try {
                              javaMailSender.send(msg);
                            }
                            catch(Exception e){
                                System.out.println("Wrong email address provided");
                            }
                        }
                        System.out.println("Done");
                    }
                };
                timer.scheduleAtFixedRate(task, 0, 43200000);


            }
        };
    }


}
