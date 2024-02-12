package com.studentrecord.project.service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.studentrecord.project.model.SecurityUser;
import com.studentrecord.project.repository.UserRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService{

	
	private final UserRepository userRepository;
	
	
	public JpaUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override  //override a method in a superclass 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository
				.findByUsername(username)
				.map(SecurityUser::new)
				.orElseThrow(()-> new UsernameNotFoundException("username not found: "+ username));
	}

	
}
