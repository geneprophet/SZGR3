package cn.ac.cncb.ngdc.szgr.dao;


import cn.ac.cncb.ngdc.szgr.entity.SNPCrispr;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SNPCrisprDAO extends PagingAndSortingRepository<SNPCrispr,Integer>, JpaSpecificationExecutor<SNPCrispr> {
}
