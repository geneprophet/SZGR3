package cn.ac.cncb.ngdc.szgr.dao;



import cn.ac.cncb.ngdc.szgr.entity.CoExpression;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CoExpressionDAO extends PagingAndSortingRepository<CoExpression,Integer>, JpaSpecificationExecutor<CoExpression> {
}
