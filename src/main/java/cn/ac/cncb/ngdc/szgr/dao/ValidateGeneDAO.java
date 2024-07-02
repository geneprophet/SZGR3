package cn.ac.cncb.ngdc.szgr.dao;


import cn.ac.cncb.ngdc.szgr.entity.ValidateGene;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ValidateGeneDAO extends PagingAndSortingRepository<ValidateGene,Integer>, JpaSpecificationExecutor<ValidateGene> {
}
