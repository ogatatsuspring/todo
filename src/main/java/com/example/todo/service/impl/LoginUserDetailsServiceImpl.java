package com.example.todo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.todo.entity.Authentication;
import com.example.todo.entity.LoginUser;
import com.example.todo.entity.Role;
import com.example.todo.repository.AuthenticationMapper;

@Service
public class LoginUserDetailsServiceImpl implements UserDetailsService {
  
  private final AuthenticationMapper authenticationMapper;
  
  public LoginUserDetailsServiceImpl ( AuthenticationMapper authenticationMapper ) {
    this.authenticationMapper = authenticationMapper;
  }
  
  @Override
  public UserDetails loadUserByUsername( String username ) throws UsernameNotFoundException {
 
/*
    if ( username.equals("tarou" ) ) {
      return new LoginUser( "tarou", "pass", Collections.emptyList() );
    } else {
      throw new UsernameNotFoundException( username + " => 指定しているユーザは存在しません" );
    }
  }
*/
    
    Authentication authentication = authenticationMapper.selectByUsername( username );
    
    if ( authentication != null ) {
      return new LoginUser( 
        authentication.getUsername(),
        authentication.getPassword(),
//        Collections.emptyList() );
        getAuthorityList( authentication.getAuthority() ) );
    } else {
      throw new UsernameNotFoundException( username + " => 指定しているユーザ名は存在しません" );
    }
    
  }
  
  
  
  private List<GrantedAuthority> getAuthorityList( Role role ) {
    List<GrantedAuthority> authorities = new ArrayList<>();
    authorities.add( new SimpleGrantedAuthority( role.name() ) );
    if ( role == role.ADMIN ) {
      authorities.add( new SimpleGrantedAuthority( Role.USER.toString() ) );
    }
    return authorities;
  }

}
