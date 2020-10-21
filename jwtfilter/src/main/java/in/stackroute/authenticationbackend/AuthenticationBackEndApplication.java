package in.stackroute.authenticationbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;

import in.stackroute.authenticationbackend.config.JwtFilter;


@SpringBootApplication
public class AuthenticationBackEndApplication {

	public FilterRegistrationBean jwtFilter()
	{
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/api/*");
		return registrationBean;
		
	}
		
	public static void main(String[] args) {
		SpringApplication.run(AuthenticationBackEndApplication.class, args);
	}
}
