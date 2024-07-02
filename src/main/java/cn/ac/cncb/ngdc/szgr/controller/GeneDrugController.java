package cn.ac.cncb.ngdc.szgr.controller;

import cn.ac.cncb.ngdc.szgr.result.Result;
import cn.ac.cncb.ngdc.szgr.service.FunctionDegService;
import cn.ac.cncb.ngdc.szgr.service.GeneDrugService;
import cn.ac.cncb.ngdc.szgr.service.ValidateGeneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneDrugController {
    @Autowired
    GeneDrugService geneDrugService;
    @Autowired
    FunctionDegService functionDegService;


    @CrossOrigin
    @GetMapping("/genedrug")
    public Result queryGeneDrugResult(@RequestParam(value = "gene",required = false) String gene,
                                    @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                    @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = geneDrugService.queryGeneDrug(pageSize,pageIndex-1,gene,sort_field,sort_direction);
        return res;
    }


    @CrossOrigin
    @GetMapping("/functiondeg")
    public Result queryGeneFuncResult(@RequestParam(value = "gene",required = false) String gene,
                                      @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                      @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                      @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                      @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = functionDegService.queryFuncDeg(pageSize,pageIndex-1,gene,sort_field,sort_direction);
        return res;
    }
}
