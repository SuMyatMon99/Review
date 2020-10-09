/*
 * package com.ucs.edu.Review.service;
 * 
 * import java.util.HashSet; import java.util.Set;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.security.core.GrantedAuthority; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.stereotype.Service; import
 * org.springframework.transaction.annotation.Transactional;
 * 
 * import com.ucs.edu.Review.model.LoginUser; import
 * com.ucs.edu.Review.model.UserRole; import
 * com.ucs.edu.Review.repository.UserRepository;
 * 
 * @Service public class AdminDetailsService implements UserDetailsService{
 * 
 * @Autowired private UserRepository userRepository;
 * 
 * 
 * @Override
 * 
 * @Transactional(readOnly = true) public UserDetails loadUserByUsername(String
 * email) throws UsernameNotFoundException { LoginUser user
 * =userRepository.findAdmin(email); if (user == null) throw new
 * UsernameNotFoundException(email); UserRole role = user.getRoles();
 * Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
 * grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
 * 
 * return new
 * org.springframework.security.core.userdetails.User(user.getEmail(),
 * user.getPassword(), grantedAuthorities); } }
 */