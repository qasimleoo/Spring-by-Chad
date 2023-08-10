package leo.springcore.com;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component // Marks as bean
@Lazy // Creates instance only while needed otherwise doesn't create any
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("Inside constructor " + getClass().getSimpleName());
    }

    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("In doMyStartupStuff(): " + getClass().getSimpleName());
    }
    @PreDestroy
    public void cleanMyStartupStuff(){
        System.out.println("In cleanMyStartupStuff(): " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes!!!!";
    }
}
