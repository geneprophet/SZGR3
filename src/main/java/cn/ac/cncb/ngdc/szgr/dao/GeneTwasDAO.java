package cn.ac.cncb.ngdc.szgr.dao;


import cn.ac.cncb.ngdc.szgr.entity.GeneTWAS;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GeneTwasDAO extends PagingAndSortingRepository<GeneTWAS,Integer>, JpaSpecificationExecutor<GeneTWAS> {
}
