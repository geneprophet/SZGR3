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
@Table(name = "validate_snp")
public class ValidateSNP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String vid;
    @Column
    private String chr;
    @Column
    private Integer start;
    @Column
    private Integer end;
    @Column
    private String gene;

    @Column
    private Integer caqtl;
    @Column
    private Integer eqtl;

    @Column
    private Integer haqtl;
    @Column
    private Integer meqtl;

    @Column
    private Integer pqtl;
    @Column
    private Integer mpra;
    @Column
    private Integer crispr;
    @Column
    private Integer score;

}
