package com.vetclinic.blo0021.controller;

import com.vetclinic.blo0021.model.Host;
import com.vetclinic.blo0021.service.HostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hosts")
public class HostController {

    @Autowired
    private HostService hostService;

    // Get all hosts
    @GetMapping
    public List<Host> getAllHosts() {
        return hostService.getAllHosts();
    }

    // Add a new host
    @PostMapping
    public Host addHost(@RequestBody Host host) {
        return hostService.saveHost(host);
    }

    // Get a specific host by ID
    @GetMapping("/{hostID}")
    public Host getHostById(@PathVariable Long hostID) {
        return hostService.getHostById(hostID);
    }

    // Update a host's details
    @PutMapping("/{hostID}")
    public Host updateHost(@PathVariable Long hostID, @RequestBody Host updatedHost) {
        return hostService.updateHost(hostID, updatedHost);
    }

    // Delete a host
    @DeleteMapping("/{hostID}")
    public void deleteHost(@PathVariable Long hostID) {
        hostService.deleteHost(hostID);
    }
}
