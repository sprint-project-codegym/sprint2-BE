package com.codegym.cinema.service.impl;
import com.codegym.cinema.entity.StatusRoom;
import com.codegym.cinema.repository.StatusRoomRepository;
import com.codegym.cinema.service.StatusRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusRoomServiceImpl implements StatusRoomService {

    @Autowired
    private StatusRoomRepository statusRoomRepository;

    @Override
    public List<StatusRoom> findAllStatusRoom() {
        return statusRoomRepository.findAll();
    }
}
