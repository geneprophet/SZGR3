package cn.ac.cncb.ngdc.szgr.dao;


import cn.ac.cncb.ngdc.szgr.entity.GeneCrispr;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GeneCrisprDAO extends PagingAndSortingRepository<GeneCrispr,Integer>, JpaSpecificationExecutor<GeneCrispr> {
}
