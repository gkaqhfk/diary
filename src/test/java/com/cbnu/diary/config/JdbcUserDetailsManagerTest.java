package com.cbnu.diary.config;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:JdbcUserDetailsManagerTest-context.xml")
public class JdbcUserDetailsManagerTest {

    @Autowired
    private DataSource dataSource;

    private JdbcUserDetailsManager jdbcUserDetailsManager;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Before
    public void before() {
        jdbcUserDetailsManager = new JdbcUserDetailsManager();
        jdbcUserDetailsManager.setDataSource(dataSource);
        bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @Test
    public void createPassword() {
        System.out.println(bCryptPasswordEncoder.encode("1234"));
    }

    @Test
    public void createUser() {
        UserDetails admin = User.builder()
                .username("admin")
                .password("$2a$10$OyLdmX6AtjK8NPhEnvFRJ.8ij6exlEh5iB8vry7x7kEknkBfmjuCe")
                .roles("ADMIN")
                .build();
        UserDetails individual = User.builder()
                .username("individual")
                .password("$2a$10$OyLdmX6AtjK8NPhEnvFRJ.8ij6exlEh5iB8vry7x7kEknkBfmjuCe")
                .roles("INDIVIDUAL")
                .build();
        UserDetails corporate = User.builder()
                .username("corporate")
                .password("$2a$10$OyLdmX6AtjK8NPhEnvFRJ.8ij6exlEh5iB8vry7x7kEknkBfmjuCe")
                .disabled(true)
                .roles("CORPORATE")
                .build();
        jdbcUserDetailsManager.createUser(admin);
        jdbcUserDetailsManager.createUser(individual);
        jdbcUserDetailsManager.createUser(corporate);
    }

    @Test
    public void loadUserByUsername() {
        UserDetails userDetails = jdbcUserDetailsManager.loadUserByUsername("individual");
        System.out.println(userDetails);
    }

}
