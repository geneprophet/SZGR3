package cn.ac.cncb.ngdc.szgr.service;

import cn.ac.cncb.ngdc.szgr.dao.SNPGeneDAO;
import cn.ac.cncb.ngdc.szgr.dao.SNPValidateDAO;
import cn.ac.cncb.ngdc.szgr.entity.SNPGene;
import cn.ac.cncb.ngdc.szgr.entity.SNPValidate;
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
public class SNPValidateService {
    @Autowired
    SNPValidateDAO snpValidateDAO;

    public Result querySNPValidate(Integer pageSize, Integer pageIndex, String vid, String sort_field, String sort_direction){
        Long total = 0L;
        List<SNPValidate> data = null;
        Meta meta = new Meta();
        Specification<SNPValidate> queryCondition = new Specification<SNPValidate>(){
            @Override
            public Predicate toPredicate(Root<SNPValidate> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (vid != null){
                    predicateList.add(criteriaBuilder.equal(root.get("vid"),vid));
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
            data = snpValidateDAO.findAll(queryCondition, PageRequest.of(pageIndex, pageSize)).getContent();
            if (vid == null ){
                total = 1L;
            }else {
                total = snpValidateDAO.count(queryCondition);
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



    public Result queryLocValidate(Integer pageSize, Integer pageIndex, String vchr, Integer vs, Integer ve, String sort_field, String sort_direction){
        Long total = 0L;
        List<SNPValidate> data = null;
        Meta meta = new Meta();
        Specification<SNPValidate> queryCondition = new Specification<SNPValidate>(){
            @Override
            public Predicate toPredicate(Root<SNPValidate> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (vchr != null && vs != null && ve != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("chr"), vchr));
                    predicateList.add(criteriaBuilder.between(root.get("start"), vs, ve));
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
            data = snpValidateDAO.findAll(queryCondition, PageRequest.of(pageIndex, pageSize)).getContent();
            if (vchr == null ){
                total = 1L;
            }else {
                total = snpValidateDAO.count(queryCondition);
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
