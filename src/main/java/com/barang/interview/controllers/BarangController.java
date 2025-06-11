package com.barang.interview.controllers;

import com.barang.interview.models.Barang;
import com.barang.interview.repository.BarangRepository;
import com.barang.interview.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class BarangController {


    @Autowired
    private BarangRepository barangrepo;

    @Autowired
    private BarangService barangService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<?> listdata() throws Exception {
        List<Barang> barangList = barangrepo.findAll();
        Map<String, Object> mapping = new HashMap<>();
        mapping.put("response", "succes");
        mapping.put("data", barangList);
        return new ResponseEntity<>(mapping, HttpStatus.OK);
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ResponseEntity<?> store(@RequestBody() Barang barang) throws Exception {
        barangrepo.save(barang);
        Map<String, Object> mapping = new HashMap<>();
        mapping.put("response", "succes inserted data");
        return new ResponseEntity<>(mapping, HttpStatus.OK);

    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@PathVariable() Long Id, @RequestBody() Barang barang) throws Exception {
        Optional<Barang> result = barangrepo.findById(Id);
        if (result.isPresent()) {
            barang.setKode(result.get().getKode());
        }

        barangrepo.save(barang);
        Map<String, Object> mapping = new HashMap<>();
        mapping.put("response", "succes inserted data");
        return new ResponseEntity<>(mapping, HttpStatus.OK);

    }

    @RequestMapping(value = "/show/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> show(@PathVariable() Long Id) throws Exception {
        Optional<Barang> result = barangrepo.findById(Id);
        Map<String, Object> mapping = new HashMap<>();
        mapping.put("response", "succes inserted data");
        mapping.put("data", result);
        return new ResponseEntity<>(mapping, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable() Long id) throws Exception {
        barangrepo.deleteById(id);
        Map<String, Object> mapping = new HashMap<>();
        mapping.put("response", "succes inserted data");
        return new ResponseEntity<>(mapping, HttpStatus.OK);
    }
}
