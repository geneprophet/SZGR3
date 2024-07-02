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
@Table(name = "snp_validate")
public class SNPValidate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
    private String gene;


    @Column
    private String celltype;



    @Column
    private String species;
    @Column
    private String trait;


    @Column
    private Integer pmid;

    @Column
    private Integer nyear;

}
