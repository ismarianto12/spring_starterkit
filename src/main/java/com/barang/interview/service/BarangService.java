package com.barang.interview.service;

import com.barang.interview.models.Barang;

import java.util.*;

public interface BarangService {
    List<Barang> listBarang();

    Barang insertBarang(Barang barang);

}
