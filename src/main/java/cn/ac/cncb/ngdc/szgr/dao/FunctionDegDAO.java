package cn.ac.cncb.ngdc.szgr.dao;


import cn.ac.cncb.ngdc.szgr.entity.FunctionDeg;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FunctionDegDAO extends PagingAndSortingRepository<FunctionDeg,Integer>, JpaSpecificationExecutor<FunctionDeg> {
}
