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
@Table(name = "snp_gene")
public class SNPGene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String vid;

    @Column
    private String loc;

    @Column
    private String chr;
    @Column
    private Integer start;

    @Column
    private Integer end;
    @Column
    private String pro_gene;

    @Column
    private String target_gene;

    @Column
    private String tissue;

    @Column
    private String celltype;

    @Column
    private String stat;

    @Column
    private String method;


}
