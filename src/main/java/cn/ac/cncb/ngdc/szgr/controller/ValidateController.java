package cn.ac.cncb.ngdc.szgr.controller;

import cn.ac.cncb.ngdc.szgr.result.Result;
import cn.ac.cncb.ngdc.szgr.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidateController {
    @Autowired
    ValidateGeneService validateGeneService;

    @Autowired
    ValidateSNPService validateSNPService;


    @CrossOrigin
    @GetMapping("/validategene")
    public Result queryValidateGeneResult(@RequestParam(value = "gene",required = false) String gene,
                                    @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                    @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = validateGeneService.queryValidateGene(pageSize,pageIndex-1,gene,sort_field,sort_direction);
        return res;
    }


    @CrossOrigin
    @GetMapping("/validategenelike")
    public Result queryValidateGeneResultlike(@RequestParam(value = "gene",required = false) String gene,
                                              @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                              @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                              @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                              @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = validateGeneService.queryValidateGenelike(pageSize,pageIndex-1,gene,sort_field,sort_direction);
        return res;
    }


    @CrossOrigin
    @GetMapping("/validatesnp")
    public Result queryValidateSNPResult(@RequestParam(value = "vid",required = false) String vid,
                                          @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                          @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                          @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                          @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = validateSNPService.queryValidateSNP(pageSize,pageIndex-1,vid,sort_field,sort_direction);
        return res;
    }
    @CrossOrigin
    @GetMapping("/validatesnplike")
    public Result queryValidateSNPResultlike(@RequestParam(value = "vid",required = false) String vid,
                                             @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                             @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                             @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                             @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = validateSNPService.queryValidateSNPlike(pageSize,pageIndex-1,vid,sort_field,sort_direction);
        return res;
    }

}
