package leo.springcore.config;

import leo.springcore.com.Coach;
import leo.springcore.com.HockeyCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportsCoach {
    @Bean
    public Coach hockeyCoach(){
        return new HockeyCoach();
    }
}
