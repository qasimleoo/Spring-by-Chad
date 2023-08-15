package leo.springcore.com;


import leo.springcore.com.Coach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class HockeyCoach implements Coach {
    public HockeyCoach() {
        System.out.println("Inside constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Hockey is the old game!!!";
    }
}
