package com.barang.interview.models;


import jakarta.persistence.*;


@Entity
@Table(name = "barang")
public class Barang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    public String getKode() {
        return Kode;
    }

    public void setKode(String kode) {
        Kode = kode;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getKuantiti() {
        return kuantiti;
    }

    public void setKuantiti(String kuantiti) {
        this.kuantiti = kuantiti;
    }

    private String Kode;
    private String Nama;
    private String kuantiti;

    public Barang() {

    }

}
