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
@Table(name = "gene_drug")
public class GeneDrug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String gene;
    @Column
    private String ensemble;
    @Column
    private String chembl_id;

    @Column
    private String drug_type;

    @Column
    private String drug_name;

    @Column
    private Integer clinical_trail;

    @Column
    private String efo_id;

    @Column
    private String efo_term;


    @Column
    private Integer phase_ind;

    @Column
    private String mesh;

    @Column
    private String warning;

    @Column
    private String action;
    @Column
    private String mechanism_comment;
    @Column
    private String mechanism_action;
    @Column
    private String target_chembl_id;
}
