package cn.ac.cncb.ngdc.szgr.service;


import cn.ac.cncb.ngdc.szgr.dao.SNPMpraDAO;
import cn.ac.cncb.ngdc.szgr.entity.SNPMpra;
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
public class SNPMpraService {
    @Autowired
    SNPMpraDAO snpMpraDAO;

    public Result querySNPMpra(Integer pageSize, Integer pageIndex, String vid, String sort_field, String sort_direction){
        Long total = 0L;
        List<SNPMpra> data = null;
        Meta meta = new Meta();
        Specification<SNPMpra> queryCondition = new Specification<SNPMpra>(){
            @Override
            public Predicate toPredicate(Root<SNPMpra> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
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
            data = snpMpraDAO.findAll(queryCondition, PageRequest.of(pageIndex, pageSize)).getContent();
            if (vid != null ){
                total = 1L;
            }else {
                total = snpMpraDAO.count(queryCondition);
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

    public Result querySNPMpralike(Integer pageSize, Integer pageIndex, String vid, String sort_field, String sort_direction){
        Long total = 0L;
        List<SNPMpra> data = null;
        Meta meta = new Meta();
        Specification<SNPMpra> queryCondition = new Specification<SNPMpra>(){
            @Override
            public Predicate toPredicate(Root<SNPMpra> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (vid != null){
                    predicateList.add(criteriaBuilder.like(root.get("vid"),"%"+vid+"%"));
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
            data = snpMpraDAO.findAll(queryCondition, PageRequest.of(pageIndex, pageSize)).getContent();
            if (vid != null ){
                total = 1L;
            }else {
                total = snpMpraDAO.count(queryCondition);
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


    public Result queryLocMpra(Integer pageSize, Integer pageIndex, String vchr, Integer vs, Integer ve, String sort_field, String sort_direction) {
        Long total = 0L;
        List<SNPMpra> data = null;
        Meta meta = new Meta();
        Specification<SNPMpra> queryCondition = new Specification<SNPMpra>() {
            @Override
            public Predicate toPredicate(Root<SNPMpra> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (vchr != null && vs != null && ve != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("chr"), vchr));
                    predicateList.add(criteriaBuilder.between(root.get("pos"), vs, ve));
                }
                if (sort_direction != null) {
                    if (sort_direction.equals("ascend")) {
                        criteriaQuery.where(criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()])));
                        criteriaQuery.orderBy(criteriaBuilder.asc(root.get(sort_field)));
                        return criteriaQuery.getRestriction();
                    } else {
                        criteriaQuery.where(criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()])));
                        criteriaQuery.orderBy(criteriaBuilder.desc(root.get(sort_field)));
                        return criteriaQuery.getRestriction();
                    }
                } else {
                    criteriaQuery.where(criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()])));
                }
                return criteriaQuery.getRestriction();
            }

            ;
        };
        try {
            data = snpMpraDAO.findAll(queryCondition, PageRequest.of(pageIndex, pageSize)).getContent();
            if (vchr != null & vs != null & ve != null) {
                total = 1L;
            } else {
                total = snpMpraDAO.count(queryCondition);
            }
            meta.setTotal(total);
            meta.setPageIndex(pageIndex + 1);
            meta.setPageSize(pageSize);
            return ResultFactory.buildSuccessResult(data, meta);
        } catch (Exception e2) {
            e2.printStackTrace();
            return ResultFactory.buildFailResult(e2.toString());
        }
    }


}
