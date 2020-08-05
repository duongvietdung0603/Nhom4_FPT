package com.DungDV13.ApiCinemaFpt.service;

import com.DungDV13.ApiCinemaFpt.model.HoaDon;
import com.DungDV13.ApiCinemaFpt.model.User;
import com.DungDV13.ApiCinemaFpt.repository.HoaDonRepository;
import com.DungDV13.ApiCinemaFpt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;


    public void save(User user) {
        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Khong tim thay id: "+id));
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
