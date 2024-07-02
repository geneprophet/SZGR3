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
@Table(name = "rna_seq")
public class RNASeq {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column
    private String gene;

    @Column
    private String log2fc;

    @Column
    private String p;

    @Column
    private String fdr;

    @Column
    private String celltype;


    @Column
    private String tissue;

    @Column
    private String study;


}
