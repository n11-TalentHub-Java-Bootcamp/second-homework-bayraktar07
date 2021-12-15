package com.bahadirmemis.springboot.dto;

import com.bahadirmemis.springboot.entity.Kullanici;
import com.bahadirmemis.springboot.entity.Urun;

import java.util.Date;

public class YorumDto {

    private Long id;
    private String yorum;
    private Date date;
    private Urun urun;
    Kullanici kullanici;

    public YorumDto() {
    }

    public YorumDto(Long id, String yorum, Date date, Urun urun, Kullanici kullanici) {
        this.id = id;
        this.yorum = yorum;
        this.date = date;
        this.urun = urun;
        this.kullanici = kullanici;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYorum() {
        return yorum;
    }

    public void setYorum(String yorum) {
        this.yorum = yorum;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    @Override
    public String toString() {
        return "YorumDto{" +
                "Yorum id=" + id +
                ", yorum='" + yorum + '\'' +
                ", date=" + date +
                ", urunId=" + urun.getId() +
                ", kullaniciId=" + kullanici.getId() +
                '}';
    }
}
