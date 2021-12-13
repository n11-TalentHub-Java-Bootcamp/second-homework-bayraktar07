package com.bahadirmemis.springboot.entity;

import javax.persistence.*;
import java.util.Date;


/**
 *  URUN_YORUM ENTITY HW STEP - 1
 * */

@Entity
@Table (name = "Urun_Yorum")
public class Yorum {

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
    Kullanici kullanici;

}
