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
@Table(name = "snp_cura")
public class SNPCura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String vtype;

    @Column
    private String vid;
    @Column
    private String loc;
    @Column
    private String vchr;
    @Column
    private Integer vs;

    @Column
    private Integer ve;

    @Column
    private String ea;

    @Column
    private String noa;

    @Column
    private String nor;

    @Column
    private String beta;

    @Column
    private String p;

    @Column
    private String gene;

    @Column
    private String trait;

    @Column
    private String pop;

    @Column
    private Integer ncase;

    @Column
    private Integer ncontrol;

    @Column
    private Integer pmid;

    @Column
    private Integer nyear;

}
