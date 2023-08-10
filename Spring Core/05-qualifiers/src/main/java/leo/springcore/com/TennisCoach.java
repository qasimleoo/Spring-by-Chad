package leo.springcore.com;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "Playing like a tennis king~";
    }
}
