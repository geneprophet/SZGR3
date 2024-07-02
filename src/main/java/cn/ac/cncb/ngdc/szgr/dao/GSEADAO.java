package cn.ac.cncb.ngdc.szgr.dao;


import cn.ac.cncb.ngdc.szgr.entity.GSEA;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GSEADAO extends PagingAndSortingRepository<GSEA,Integer>, JpaSpecificationExecutor<GSEA> {
}
