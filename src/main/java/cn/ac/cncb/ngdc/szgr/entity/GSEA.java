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
@Table(name = "tool_gsea")
public class GSEA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String gene;

    @Column
    private String scores;
    @Column
    private String logfc;
    @Column
    private String p;
    @Column
    private String padj;

    @Column
    private String cell_type;

    @Column
    private String study;

    @Column
    private String brain_region;



}
