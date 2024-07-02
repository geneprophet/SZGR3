package cn.ac.cncb.ngdc.szgr.service;


import cn.ac.cncb.ngdc.szgr.dao.CoExpressionDAO;
import cn.ac.cncb.ngdc.szgr.entity.CoExpression;
import cn.ac.cncb.ngdc.szgr.result.Meta;
import cn.ac.cncb.ngdc.szgr.result.Result;
import cn.ac.cncb.ngdc.szgr.result.ResultFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoExpressionService {
    @Autowired
    CoExpressionDAO coExpressionDAO;

    public Result queryCoExpression(Integer pageSize, Integer pageIndex,String tissue,String celltype,String[] gene, String sort_field, String sort_direction){
        Long total = 0L;
        List<CoExpression> data = null;
        Meta meta = new Meta();
        Specification<CoExpression> queryCondition = new Specification<CoExpression>(){
            @Override
            public Predicate toPredicate(Root<CoExpression> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateListAnd = new ArrayList<>();
                if (tissue != null){
                    predicateListAnd.add(criteriaBuilder.equal(root.get("tissue"),tissue));
                }
                if (celltype != null){
                    predicateListAnd.add(criteriaBuilder.equal(root.get("celltype"),celltype));
                }
                if (gene != null){
                    Path<Object> path1 = root.get("source");
                    Path<Object> path2 = root.get("gene");
                    CriteriaBuilder.In<Object> in1 = criteriaBuilder.in(path1);
                    CriteriaBuilder.In<Object> in2 = criteriaBuilder.in(path2);
                    for (String element : gene) {
                        in1.value(element);
                        in2.value(element);
                    }
                    predicateListAnd.add(criteriaBuilder.and(in1,in2));
                }
                Predicate predicateAND = criteriaBuilder.and(predicateListAnd.toArray(new Predicate[predicateListAnd.size()]));

                if (sort_direction != null){
                    if (sort_direction.equals("ascend")){
                        criteriaQuery.where(predicateAND);
                        criteriaQuery.orderBy(criteriaBuilder.asc(root.get(sort_field)));
                        return criteriaQuery.getRestriction();
                    }else {
                        criteriaQuery.where(predicateAND);
                        criteriaQuery.orderBy(criteriaBuilder.desc(root.get(sort_field)));
                        return criteriaQuery.getRestriction();
                    }
                }else {
                    criteriaQuery.where(predicateAND);
                }
                return criteriaQuery.getRestriction();
            };
        };
        try {
            data = coExpressionDAO.findAll(queryCondition, PageRequest.of(pageIndex, pageSize)).getContent();

            total = coExpressionDAO.count(queryCondition);

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
