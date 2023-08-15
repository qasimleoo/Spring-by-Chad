package leo.springcore.com;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TrackCoach implements Coach{
    public TrackCoach() {
        System.out.println("Inside constructor " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Let's do some tracking here";
    }
}
