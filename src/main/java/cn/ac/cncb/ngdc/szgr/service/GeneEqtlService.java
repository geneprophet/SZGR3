package cn.ac.cncb.ngdc.szgr.service;

import cn.ac.cncb.ngdc.szgr.dao.GeneEqtlDAO;
import cn.ac.cncb.ngdc.szgr.dao.SNPCuraDAO;
import cn.ac.cncb.ngdc.szgr.entity.GeneEqtl;
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
public class GeneEqtlService {
    @Autowired
    GeneEqtlDAO geneEqtlDAO;

    public Result queryGeneEqtl(Integer pageSize, Integer pageIndex, String gene, String sort_field, String sort_direction){
        Long total = 0L;
        List<GeneEqtl> data = null;
        Meta meta = new Meta();
        Specification<GeneEqtl> queryCondition = new Specification<GeneEqtl>(){
            @Override
            public Predicate toPredicate(Root<GeneEqtl> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (gene != null){
                    predicateList.add(criteriaBuilder.equal(root.get("gene"),gene));
                }
                predicateList.add(criteriaBuilder.equal(root.get("qtl"),"eQTL"));

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
            data = geneEqtlDAO.findAll(queryCondition, PageRequest.of(pageIndex, pageSize)).getContent();
            if (gene != null ){
                total = 1L;
            }else {
                total = geneEqtlDAO.count(queryCondition);
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
    public Result queryGeneMeqtl(Integer pageSize, Integer pageIndex, String gene, String sort_field, String sort_direction){
        Long total = 0L;
        List<GeneEqtl> data = null;
        Meta meta = new Meta();
        Specification<GeneEqtl> queryCondition = new Specification<GeneEqtl>(){
            @Override
            public Predicate toPredicate(Root<GeneEqtl> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (gene != null){
                    predicateList.add(criteriaBuilder.equal(root.get("gene"),gene));
                }
                predicateList.add(criteriaBuilder.equal(root.get("qtl"),"meQTL"));
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
            data = geneEqtlDAO.findAll(queryCondition, PageRequest.of(pageIndex, pageSize)).getContent();
            if (gene != null ){
                total = 1L;
            }else {
                total = geneEqtlDAO.count(queryCondition);
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
    public Result queryGenePqtl(Integer pageSize, Integer pageIndex, String gene, String sort_field, String sort_direction){
        Long total = 0L;
        List<GeneEqtl> data = null;
        Meta meta = new Meta();
        Specification<GeneEqtl> queryCondition = new Specification<GeneEqtl>(){
            @Override
            public Predicate toPredicate(Root<GeneEqtl> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (gene != null){
                    predicateList.add(criteriaBuilder.equal(root.get("gene"),gene));
                }
                predicateList.add(criteriaBuilder.equal(root.get("qtl"),"pQTL"));
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
            data = geneEqtlDAO.findAll(queryCondition, PageRequest.of(pageIndex, pageSize)).getContent();
            if (gene != null ){
                total = 1L;
            }else {
                total = geneEqtlDAO.count(queryCondition);
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

    public Result queryGeneColoc(Integer pageSize, Integer pageIndex, String gene, String sort_field, String sort_direction){
        Long total = 0L;
        List<GeneEqtl> data = null;
        Meta meta = new Meta();
        Specification<GeneEqtl> queryCondition = new Specification<GeneEqtl>(){
            @Override
            public Predicate toPredicate(Root<GeneEqtl> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (gene != null){
                    predicateList.add(criteriaBuilder.equal(root.get("gene"),gene));
                }
                predicateList.add(criteriaBuilder.equal(root.get("evidence"),"COLOC"));
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
            data = geneEqtlDAO.findAll(queryCondition, PageRequest.of(pageIndex, pageSize)).getContent();
            if (gene != null ){
                total = 1L;
            }else {
                total = geneEqtlDAO.count(queryCondition);
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

    public Result queryGeneSmr(Integer pageSize, Integer pageIndex, String gene, String sort_field, String sort_direction){
        Long total = 0L;
        List<GeneEqtl> data = null;
        Meta meta = new Meta();
        Specification<GeneEqtl> queryCondition = new Specification<GeneEqtl>(){
            @Override
            public Predicate toPredicate(Root<GeneEqtl> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (gene != null){
                    predicateList.add(criteriaBuilder.equal(root.get("gene"),gene));
                }
                predicateList.add(criteriaBuilder.equal(root.get("evidence"),"SMR"));

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
            data = geneEqtlDAO.findAll(queryCondition, PageRequest.of(pageIndex, pageSize)).getContent();
            if (gene != null ){
                total = 1L;
            }else {
                total = geneEqtlDAO.count(queryCondition);
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
