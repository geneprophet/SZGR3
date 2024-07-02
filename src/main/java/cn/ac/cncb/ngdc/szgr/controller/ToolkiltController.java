package cn.ac.cncb.ngdc.szgr.controller;

import cn.ac.cncb.ngdc.szgr.result.Result;
import cn.ac.cncb.ngdc.szgr.result.ResultFactory;
import cn.ac.cncb.ngdc.szgr.service.CoExpressionService;
import cn.ac.cncb.ngdc.szgr.service.GSEAService;
import cn.ac.cncb.ngdc.szgr.service.ValidateGeneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.NullLiteral;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class ToolkiltController {
    @Autowired
    GSEAService gseaService;
    @Autowired
    CoExpressionService coExpressionService;


    @CrossOrigin
    @GetMapping("/gsea")
    public Result queryValidateGeneResult(@RequestParam(value = "gene",required = false) String gene,
                                    @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                    @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = gseaService.queryGSEA(pageSize,pageIndex-1,gene,sort_field,sort_direction);
        return res;
    }


    @CrossOrigin
    @GetMapping("/coexpression")
    public Result queryCoExpressionResult(@RequestParam(value = "gene",required = false) String gene,
                                          @RequestParam(value = "tissue",required = false,defaultValue = "id") String tissue,
                                          @RequestParam(value = "celltype",required = false,defaultValue = "id") String celltype,
                                          @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                          @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                          @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                          @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        System.out.println(gene);
        String[] stringArray = gene.split(",");
        System.out.println(Arrays.toString(stringArray));
        Result res = coExpressionService.queryCoExpression(pageSize,pageIndex-1,tissue,celltype,stringArray,sort_field,sort_direction);
        return res;
    }

}
