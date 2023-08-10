package leo.springcore.com;

import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{
    public TrackCoach() {
        System.out.println("Inside constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Let's do some tracking here";
    }
}
