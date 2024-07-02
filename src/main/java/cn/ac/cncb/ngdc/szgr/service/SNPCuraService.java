package cn.ac.cncb.ngdc.szgr.service;

import cn.ac.cncb.ngdc.szgr.dao.SNPCrisprDAO;
import cn.ac.cncb.ngdc.szgr.dao.SNPCuraDAO;
import cn.ac.cncb.ngdc.szgr.entity.SNPCrispr;
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
public class SNPCuraService {
    @Autowired
    SNPCuraDAO snpcuraDAO;

    @Autowired
    SNPCrisprDAO snpcrisprDAO;

    public Result querySNPCura(Integer pageSize, Integer pageIndex, String vid, String vtype, String pop, String sort_field, String sort_direction) {
        Long total = 0L;
        List<SNPCura> data = null;
        Meta meta = new Meta();
        Specification<SNPCura> queryCondition = new Specification<SNPCura>() {
            @Override
            public Predicate toPredicate(Root<SNPCura> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (vid != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("vid"), vid));
                }
                if (vtype != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("vtype"), vtype));
                }
                if (pop != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("pop"), pop));
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
        };
        try {
            data = snpcuraDAO.findAll(queryCondition, PageRequest.of(pageIndex, pageSize)).getContent();

            System.out.println("data:"+data);

            if (vid != null) {
                total = 1L;
            } else {
                total = snpcuraDAO.count(queryCondition);
            }
            meta.setTotal(total);
            meta.setPageIndex(pageIndex + 1);
            meta.setPageSize(pageSize);
            return ResultFactory.buildSuccessResult(data, meta);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult(e.toString());
        }
    }
    public Result querySNPCuraLike(Integer pageSize, Integer pageIndex, String vid, String vtype, String pop,String sort_field,String sort_direction){
        Long total = 0L;
        List<SNPCura> data = null;
        Meta meta = new Meta();
        Specification<SNPCura> queryCondition = new Specification<SNPCura>(){
            @Override
            public Predicate toPredicate(Root<SNPCura> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                    List<Predicate> predicateList = new ArrayList<>();
                    if (vid != null){
                        predicateList.add(criteriaBuilder.like(root.get("vid"),"%"+vid+"%"));
                    }
                    if (vtype != null){
                        predicateList.add(criteriaBuilder.like(root.get("vtype"),"%"+vtype+"%"));
                    }
                    if (pop != null){
                        predicateList.add(criteriaBuilder.like(root.get("pop"),"%"+pop+"%"));
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
                        return criteriaQuery.getRestriction();
                    }

            };
        };
        try {
            data = snpcuraDAO.findAll(queryCondition, PageRequest.of(pageIndex, pageSize)).getContent();
            total = snpcuraDAO.count(queryCondition);
            meta.setTotal(total);
            meta.setPageIndex(pageIndex+1);
            meta.setPageSize(pageSize);
            return ResultFactory.buildSuccessResult(data,meta);
        } catch (Exception e){
            e.printStackTrace();
            return ResultFactory.buildFailResult(e.toString());
        }

    }

    public Result queryLocCura(Integer pageSize, Integer pageIndex, String vchr, Integer vs, Integer ve, String sort_field, String sort_direction) {
        Long total = 0L;
        List<SNPCura> data = null;
        Meta meta = new Meta();
        Specification<SNPCura> queryCondition = new Specification<SNPCura>() {
            @Override
            public Predicate toPredicate(Root<SNPCura> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (vchr != null && vs != null && ve != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("vchr"), vchr));
                    predicateList.add(criteriaBuilder.between(root.get("vs"), vs, ve));
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
            data = snpcuraDAO.findAll(queryCondition, PageRequest.of(pageIndex, pageSize)).getContent();
            if (vchr != null & vs != null & ve != null) {
                total = 1L;
            } else {
                total = snpcuraDAO.count(queryCondition);
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


    public Result querySNPCrispr(Integer pageSize, Integer pageIndex, String vid, String sort_field, String sort_direction) {

        List<SNPCura> data = null;

        Specification<SNPCura> queryCondition = new Specification<SNPCura>() {
            @Override
            public Predicate toPredicate(Root<SNPCura> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (vid != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("vid"), vid));
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
        };
        try {
            data = snpcuraDAO.findAll(queryCondition, PageRequest.of(pageIndex, pageSize)).getContent();
            String chr= data.get(0).getVchr();
            Integer start=data.get(0).getVs();

            Long total = 0L;
            List<SNPCrispr> data2 = null;
            Meta meta = new Meta();

            Specification<SNPCrispr> queryCondition2 = new Specification<SNPCrispr>() {
                @Override
                public Predicate toPredicate(Root<SNPCrispr> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    List<Predicate> predicateList = new ArrayList<>();
                        predicateList.add(criteriaBuilder.equal(root.get("chr"),chr));
                        predicateList.add(criteriaBuilder.lessThanOrEqualTo(root.get("start"), start));
                        predicateList.add(criteriaBuilder.greaterThanOrEqualTo(root.get("end"), start));
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

            };
            try {
                data2 = snpcrisprDAO.findAll(queryCondition2, PageRequest.of(pageIndex, pageSize)).getContent();
                System.out.println("data2:" + data2);

                if (chr != null ) {
                    total = 1L;
                } else {
                    total = snpcrisprDAO.count(queryCondition2);
                }
                meta.setTotal(total);
                meta.setPageIndex(pageIndex + 1);
                meta.setPageSize(pageSize);
                return ResultFactory.buildSuccessResult(data2, meta);
            } catch (Exception e2) {
                e2.printStackTrace();
                return ResultFactory.buildFailResult(e2.toString());
            }


        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult(e.toString());
        }

    }
    public Result querySNPCrisprlike(Integer pageSize, Integer pageIndex, String vid, String sort_field, String sort_direction) {

        List<SNPCura> data = null;

        Specification<SNPCura> queryCondition = new Specification<SNPCura>() {
            @Override
            public Predicate toPredicate(Root<SNPCura> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (vid != null) {
                    predicateList.add(criteriaBuilder.like(root.get("vid"), "%"+vid+"%"));
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
        };
        try {
            data = snpcuraDAO.findAll(queryCondition, PageRequest.of(pageIndex, pageSize)).getContent();
            String chr= data.get(0).getVchr();
            Integer start=data.get(0).getVs();

            Long total = 0L;
            List<SNPCrispr> data2 = null;
            Meta meta = new Meta();

            Specification<SNPCrispr> queryCondition2 = new Specification<SNPCrispr>() {
                @Override
                public Predicate toPredicate(Root<SNPCrispr> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    List<Predicate> predicateList = new ArrayList<>();
                    predicateList.add(criteriaBuilder.equal(root.get("chr"),chr));
                    predicateList.add(criteriaBuilder.lessThanOrEqualTo(root.get("start"), start));
                    predicateList.add(criteriaBuilder.greaterThanOrEqualTo(root.get("end"), start));
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

            };
            try {
                data2 = snpcrisprDAO.findAll(queryCondition2, PageRequest.of(pageIndex, pageSize)).getContent();
                System.out.println("data2:" + data2);

                if (chr != null ) {
                    total = 1L;
                } else {
                    total = snpcrisprDAO.count(queryCondition2);
                }
                meta.setTotal(total);
                meta.setPageIndex(pageIndex + 1);
                meta.setPageSize(pageSize);
                return ResultFactory.buildSuccessResult(data2, meta);
            } catch (Exception e2) {
                e2.printStackTrace();
                return ResultFactory.buildFailResult(e2.toString());
            }


        } catch (Exception e) {
            e.printStackTrace();
            return ResultFactory.buildFailResult(e.toString());
        }

    }

    public Result queryLocCrispr(Integer pageSize, Integer pageIndex, String vchr, Integer vs, Integer ve, String sort_field, String sort_direction) {
        Long total = 0L;
        List<SNPCrispr> data = null;
        Meta meta = new Meta();
        Specification<SNPCrispr> queryCondition = new Specification<SNPCrispr>() {
            @Override
            public Predicate toPredicate(Root<SNPCrispr> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                if (vchr != null && vs != null && ve != null) {
                    predicateList.add(criteriaBuilder.equal(root.get("chr"), vchr));
                    predicateList.add(criteriaBuilder.between(root.get("start"), vs, ve));
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

        };
        try {
            data = snpcrisprDAO.findAll(queryCondition, PageRequest.of(pageIndex, pageSize)).getContent();
            if (vchr != null & vs != null & ve != null) {
                total = 1L;
            } else {
                total = snpcrisprDAO.count(queryCondition);
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



