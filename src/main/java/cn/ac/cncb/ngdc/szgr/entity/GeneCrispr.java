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
@Table(name = "gene_crispr")
public class GeneCrispr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String technology;

    @Column
    private String grna;
    @Column
    private String gene;
    @Column
    private String chr;
    @Column
    private Integer start;

    @Column
    private Integer end;

    @Column
    private String diff;

    @Column
    private String log2fc;

    @Column
    private String p;

    @Column
    private String fdr;

    @Column
    private String celltype;

    @Column
    private Integer year;

    @Column
    private Integer pmid;


}
