package com.barang.interview.service;

import com.barang.interview.models.Barang;
import com.barang.interview.repository.BarangRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BarangServiceImpl implements BarangService {


    private final BarangRepository barangrepo;

    public BarangServiceImpl(BarangRepository barangrepo) {
        this.barangrepo = barangrepo;
    }

    @Override
    public List<Barang> listBarang() {
        List<Barang> barang = barangrepo.findAll();
        return barang;
    }
    @Override
    public Barang insertBarang(Barang barang) {
        return barangrepo.save(barang);
    }

}
