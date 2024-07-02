package cn.ac.cncb.ngdc.szgr.dao;


import cn.ac.cncb.ngdc.szgr.entity.RNASeq;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RNASeqDAO extends PagingAndSortingRepository<RNASeq,Integer>, JpaSpecificationExecutor<RNASeq> {
}
