package cn.ac.cncb.ngdc.szgr.service;

import cn.ac.cncb.ngdc.szgr.dao.GeneDegDAO;
import cn.ac.cncb.ngdc.szgr.dao.SNPCuraDAO;
import cn.ac.cncb.ngdc.szgr.entity.GeneDeg;
import cn.ac.cncb.ngdc.szgr.entity.SNPCura;
import cn.ac.cncb.ngdc.szgr.result.Meta;
import cn.ac.cncb.ngdc.szgr.result.Result;
import cn.ac.cncb.ngdc.szgr.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class GeneDegService {
    @Autowired
    GeneDegDAO geneDegDAO;

    public Result queryGeneDeg(Integer pageSize, Integer pageIndex, String gene,String evidence,  String sort_field, String sort_direction){
        Long total = 0L;
        List<GeneDeg> data = null;
        Meta meta = new Meta();
        Specification<GeneDeg> queryCondition = new Specification<GeneDeg>(){
            @Override
            public Predicate toPredicate(Root<GeneDeg> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (gene != null){
                    predicateList.add(criteriaBuilder.equal(root.get("gene"),gene));
                }
                if (evidence != null){
                    predicateList.add(criteriaBuilder.equal(root.get("evidence"),evidence));
                }
                if (sort_direction != null){
                    if (sort_direction.equals("ascend")){
                        criteriaQuery.where(criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()])));
                        criteriaQuery.orderBy(criteriaBuilder.asc(root.get(sort_field)));
                        return criteriaQuery.getRestriction();
                    }else {
                        criteriaQuery.where(criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()])));
                        criteriaQuery.orderBy(criteriaBuilder.desc(root.get(sort_field)));
                        return criteriaQuery.getRestriction();
                    }
                }else {
                    criteriaQuery.where(criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()])));
                }
                return criteriaQuery.getRestriction();
            };
        };
        try {
            data = geneDegDAO.findAll(queryCondition, PageRequest.of(pageIndex, pageSize)).getContent();
            if (gene != null ){
                total = 1L;
            }else {
                total = geneDegDAO.count(queryCondition);
            }
            meta.setTotal(total);
            meta.setPageIndex(pageIndex + 1);
            meta.setPageSize(pageSize);
            return ResultFactory.buildSuccessResult(data,meta);
        } catch (Exception e){
            e.printStackTrace();
            return ResultFactory.buildFailResult(e.toString());
        }
    }

}
