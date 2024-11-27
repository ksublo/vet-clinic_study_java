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

    @GetMapping
    public List<Host> getAllHosts() {
        return hostService.getAllHosts();
    }

    @PostMapping
    public Host addHost(@RequestBody Host host) {
        return hostService.saveHost(host);
    }
}
