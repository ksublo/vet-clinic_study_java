package com.vetclinic.blo0021.service;

import com.vetclinic.blo0021.model.Host;
import com.vetclinic.blo0021.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HostService {

    @Autowired
    private HostRepository hostRepository;

    public List<Host> getAllHosts() {
        return hostRepository.findAll();
    }

    public Host saveHost(Host host) {
        return hostRepository.save(host);
    }
}
