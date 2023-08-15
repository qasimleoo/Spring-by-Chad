package leo.springcore.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Coach myCoach;

    //We can use ID to access a class, other than class's name
    @Autowired
    public Controller(@Qualifier("bean") Coach theCoach){
        myCoach = theCoach;
    }

    //@Qualifier has higher priority than @Primary annotation and recommended is also @Qualifier

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
