package org.springsecurity.multauthentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

//@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	
	
	@Configuration
	@Order(1)
	class UnauthorizedSecurityConfig extends WebSecurityConfigurerAdapter{

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			System.out.println("...Unauthorized Security Config....");
			http.antMatcher("/api/smuser/**").addFilterAt(siteMinderFilter(), UsernamePasswordAuthenticationFilter.class)
			
			.authorizeRequests().anyRequest().permitAll();
			
		}	
		
		@Bean
		public SiteMinderFilter siteMinderFilter(){
			return new SiteMinderFilter();			
		}
		
	}
	
	
	
	@Configuration
	@Order(2)
	 class JwtTokenSecurityConfig extends WebSecurityConfigurerAdapter{

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			 http.antMatcher("/api/jwt/**")
             .addFilterAt(jwtFilter(), RequestHeaderAuthenticationFilter.class)        
             .authorizeRequests()
             .antMatchers("/api/jwt/unauthorized/**").permitAll()
             .anyRequest().permitAll()
             .and()
             .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);		
		}
		
		@Bean
		public JwtFilter jwtFilter(){
			return new JwtFilter();			
		}
		
	}
	
	
	

}
