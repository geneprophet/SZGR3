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
@Table(name = "gene_twas")
public class GeneTWAS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String evidence;

    @Column
    private String gene;

    @Column
    private String beta;

    @Column
    private String t_z;

    @Column
    private String p;

    @Column
    private String fdr;

    @Column
    private String celltype;


    @Column
    private String trait;

    @Column
    private String pop;

    @Column
    private Integer n_case;

    @Column
    private Integer n_control;

    @Column
    private Integer pmid;

    @Column
    private Integer year;



}
