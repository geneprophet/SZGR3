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
@Table(name = "validate_gene")
public class ValidateGene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String gene;
    @Column
    private Integer deg;

    @Column
    private Integer dep;

    @Column
    private Integer dmg;

    @Column
    private Integer twas;
    @Column
    private Integer ewas;
    @Column
    private Integer eqtl;
    @Column
    private Integer meqtl;
    @Column
    private Integer crispr_hit;
    @Column
    private Integer crispr_hit_targets;
    @Column
    private Integer other_expriments;
    @Column
    private Integer score;

}
