package cn.ac.cncb.ngdc.szgr.dao;


import cn.ac.cncb.ngdc.szgr.entity.GeneDeg;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GeneDegDAO extends PagingAndSortingRepository<GeneDeg,Integer>, JpaSpecificationExecutor<GeneDeg> {
}
