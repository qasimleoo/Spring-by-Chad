package leo.springcore.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private Coach myCoach;
    @Autowired
//    public Controller(@Qualifier("trackCoach") Coach theCoach){
//        myCoach = theCoach;
//    }
    public Controller(Coach theCoach){
        myCoach = theCoach;
    }

    //@Qualifier has higher priority than @Primary annotation and recommended is also @Qualifier

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
}
