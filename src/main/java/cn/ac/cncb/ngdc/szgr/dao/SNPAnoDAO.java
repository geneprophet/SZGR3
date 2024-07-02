package cn.ac.cncb.ngdc.szgr.dao;


import cn.ac.cncb.ngdc.szgr.entity.SNPAno;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SNPAnoDAO extends PagingAndSortingRepository<SNPAno,Integer>, JpaSpecificationExecutor<SNPAno> {
}
