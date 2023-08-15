package leo.springcore.com;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    public TennisCoach() {
        System.out.println("Inside constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Playing like a tennis king~";
    }
}
