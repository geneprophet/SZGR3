package cn.ac.cncb.ngdc.szgr.dao;


import cn.ac.cncb.ngdc.szgr.entity.DMG;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DMGDAO extends PagingAndSortingRepository<DMG,Integer>, JpaSpecificationExecutor<DMG> {
}
