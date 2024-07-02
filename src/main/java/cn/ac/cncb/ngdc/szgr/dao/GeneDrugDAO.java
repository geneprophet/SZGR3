package cn.ac.cncb.ngdc.szgr.dao;



import cn.ac.cncb.ngdc.szgr.entity.GeneDrug;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GeneDrugDAO extends PagingAndSortingRepository<GeneDrug,Integer>, JpaSpecificationExecutor<GeneDrug> {
}
