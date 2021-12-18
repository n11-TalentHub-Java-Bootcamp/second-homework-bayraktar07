package com.bahadirmemis.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *  URUN_YORUM ENTITY HW STEP - 1
 * */
@Entity
@Table (name = "Urun_Yorum")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Yorum implements Serializable {

    @SequenceGenerator(name = "generator", sequenceName = "YORUM_ID_SEQ")
    @Id
    @GeneratedValue(generator = "generator")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "YORUM",length = 500, nullable = false)
    private String yorum;

    @Column(name = "YORUM_TARIHI", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "URUN_ID", foreignKey = @ForeignKey(name = "FK_URUN_YORUM_ID"))
    private Urun urun;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KULLANICI_ID", foreignKey = @ForeignKey(name = "FK_KULLANICI_YORUM_ID"))
    @OnDelete(action = OnDeleteAction.CASCADE)
    Kullanici kullanici;

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
}
