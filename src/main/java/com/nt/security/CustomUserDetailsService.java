package com.nt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.entity.User;
import com.nt.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	
	@Autowired
	private UserRepository urepo;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
	User u=	urepo.findByEmail(email);

	return new CustomUser(u);
	
	}
}
