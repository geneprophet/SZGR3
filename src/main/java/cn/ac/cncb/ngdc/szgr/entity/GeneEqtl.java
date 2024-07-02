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
@Table(name = "gene_eqtl")
public class GeneEqtl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String evidence;

    @Column
    private String qtl;

    @Column
    private String gene;

    @Column
    private String pph3;

    @Column
    private String pph4;
    @Column
    private String fdr;

    @Column
    private String p;

    @Column
    private String celltype;


    @Column
    private String trait;

    @Column
    private String pop;


    @Column
    private Integer pmid;

    @Column
    private Integer year;

}
