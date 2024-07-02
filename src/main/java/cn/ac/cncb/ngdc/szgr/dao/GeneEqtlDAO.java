package cn.ac.cncb.ngdc.szgr.dao;


import cn.ac.cncb.ngdc.szgr.entity.GeneEqtl;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GeneEqtlDAO extends PagingAndSortingRepository<GeneEqtl,Integer>, JpaSpecificationExecutor<GeneEqtl> {
}
