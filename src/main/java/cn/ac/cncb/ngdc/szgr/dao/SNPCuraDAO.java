package cn.ac.cncb.ngdc.szgr.dao;


import cn.ac.cncb.ngdc.szgr.entity.SNPCura;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SNPCuraDAO extends PagingAndSortingRepository<SNPCura,Integer>, JpaSpecificationExecutor<SNPCura> {
}
