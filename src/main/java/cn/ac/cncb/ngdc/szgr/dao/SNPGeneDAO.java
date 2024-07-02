package cn.ac.cncb.ngdc.szgr.dao;


import cn.ac.cncb.ngdc.szgr.entity.SNPGene;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SNPGeneDAO extends PagingAndSortingRepository<SNPGene,Integer>, JpaSpecificationExecutor<SNPGene> {
}
