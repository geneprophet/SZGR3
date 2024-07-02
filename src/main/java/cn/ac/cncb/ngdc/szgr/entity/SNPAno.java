package cn.ac.cncb.ngdc.szgr.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "snp_ano")
public class SNPAno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String vid;
    @Column
    private String alle;
    @Column
    private String vchr;
    @Column
    private String vpos;

    @Column
    private String afr;

    @Column
    private String amr;

    @Column
    private String eas;

    @Column
    private String eur;

    @Column
    private String sas;

    @Column
    private String cadd;

    @Column
    private String fit;

    @Column
    private String eigen;

    @Column
    private String pc;

    @Column
    private String funseq;


}
