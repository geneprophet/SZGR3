package cn.ac.cncb.ngdc.szgr.dao;


import cn.ac.cncb.ngdc.szgr.entity.SNPValidate;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SNPValidateDAO extends PagingAndSortingRepository<SNPValidate,Integer>, JpaSpecificationExecutor<SNPValidate> {
}
