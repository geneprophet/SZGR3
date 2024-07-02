package cn.ac.cncb.ngdc.szgr.dao;



import cn.ac.cncb.ngdc.szgr.entity.ValidateSNP;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ValidateSNPDAO extends PagingAndSortingRepository<ValidateSNP,Integer>, JpaSpecificationExecutor<ValidateSNP> {
}
