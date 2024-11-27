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

    // Fetch all hosts
    public List<Host> getAllHosts() {
        return hostRepository.findAll();
    }

    // Add a new host
    public Host saveHost(Host host) {
        return hostRepository.save(host);
    }

    // Find a host by ID
    public Host getHostById(Long hostID) {
        return hostRepository.findById(hostID).orElseThrow(() -> new RuntimeException("Host not found!"));
    }

    // Update a host's details
    public Host updateHost(Long hostID, Host updatedHost) {
        Host host = getHostById(hostID);
        host.setFirstName(updatedHost.getFirstName());
        host.setLastName(updatedHost.getLastName());
        host.setAddress(updatedHost.getAddress());
        host.setPhone(updatedHost.getPhone());
        host.setEmail(updatedHost.getEmail());
        return hostRepository.save(host);
    }

    // Delete a host
    public void deleteHost(Long hostID) {
        hostRepository.deleteById(hostID);
    }
}
