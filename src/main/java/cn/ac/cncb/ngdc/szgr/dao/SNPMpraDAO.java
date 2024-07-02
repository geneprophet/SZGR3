package cn.ac.cncb.ngdc.szgr.dao;


import cn.ac.cncb.ngdc.szgr.entity.SNPMpra;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SNPMpraDAO extends PagingAndSortingRepository<SNPMpra,Integer>, JpaSpecificationExecutor<SNPMpra> {
}
