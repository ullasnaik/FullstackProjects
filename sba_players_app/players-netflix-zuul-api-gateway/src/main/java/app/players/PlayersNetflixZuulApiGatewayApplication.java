package app.players;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class PlayersNetflixZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayersNetflixZuulApiGatewayApplication.class, args);
	}
}
