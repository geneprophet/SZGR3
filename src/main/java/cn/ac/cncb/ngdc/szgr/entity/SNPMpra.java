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
@Table(name = "snp_mpra")
public class SNPMpra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String vid;

    @Column
    private String chr;
    @Column
    private String pos;
    @Column
    private String ref;
    @Column
    private String alt;

    @Column
    private String strand;

    @Column
    private String hap;

    @Column
    private String log2fc_ref;

    @Column
    private String p_ref;

    @Column
    private String padj_ref;

    @Column
    private String log2fc_alt;

    @Column
    private String p_alt;

    @Column
    private String padj_alt;

    @Column
    private String celltype;

    @Column
    private Integer year;

    @Column
    private Integer pmid;


}
