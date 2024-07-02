package cn.ac.cncb.ngdc.szgr.dao;


import cn.ac.cncb.ngdc.szgr.entity.GeneMpra;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GeneMpraDAO extends PagingAndSortingRepository<GeneMpra,Integer>, JpaSpecificationExecutor<GeneMpra> {
}
