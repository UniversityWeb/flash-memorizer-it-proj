package com.uniteam.flashmemorizer.service.impl;

<<<<<<< HEAD

=======
>>>>>>> 8eb0604 (load account from db to verify)
import com.uniteam.flashmemorizer.dto.UserHolder;
import com.uniteam.flashmemorizer.entity.User;
import com.uniteam.flashmemorizer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
<<<<<<< HEAD
import org.springframework.stereotype.Component;
=======
>>>>>>> 8eb0604 (load account from db to verify)
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

<<<<<<< HEAD
@Component
=======
>>>>>>> 8eb0604 (load account from db to verify)
@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()));

        return new UserHolder(user, authorities);
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 8eb0604 (load account from db to verify)
