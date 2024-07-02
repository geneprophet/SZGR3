package cn.ac.cncb.ngdc.szgr.controller;

import cn.ac.cncb.ngdc.szgr.result.Result;
import cn.ac.cncb.ngdc.szgr.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneCuraController {
    @Autowired
    GeneCuraService geneCuraService;

    @Autowired
    GeneDegService geneDegService;

    @Autowired
    GeneTWASService geneTWASService;

    @Autowired
    GeneCrisprService geneCrisprService;
    @Autowired
    GeneEqtlService geneEqtlService;
    @Autowired
    RNASeqService rnaSeqService;

    @Autowired
    DMGService dmgService;

    @CrossOrigin
    @GetMapping("/genecuration")
    public Result queryGeneCuraResult(@RequestParam(value = "gene",required = false) String gene,
                                    @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                    @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = geneCuraService.queryGeneCura(pageSize,pageIndex-1,gene,sort_field,sort_direction);
        return res;
    }


    @CrossOrigin
    @GetMapping("/genedeg")
    public Result queryGeneDegResult(@RequestParam(value = "gene",required = false) String gene,
                                 @RequestParam(value = "evidence",required = false,defaultValue = "id") String evidence,
                                 @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                 @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                 @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = geneDegService.queryGeneDeg(pageSize,pageIndex-1,gene,evidence,sort_field,sort_direction);
        return res;
    }

    @CrossOrigin
    @GetMapping("/genetwas")
    public Result queryGeneTwasResult(@RequestParam(value = "gene",required = false) String gene,
                                    @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                    @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = geneTWASService.queryGeneTwas(pageSize,pageIndex-1,gene,sort_field,sort_direction);
        return res;
    }

    @CrossOrigin
    @GetMapping("/geneewas")
    public Result queryGeneEwasResult(@RequestParam(value = "gene",required = false) String gene,
                                      @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                      @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                      @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                      @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = geneTWASService.queryGeneEwas(pageSize,pageIndex-1,gene,sort_field,sort_direction);
        return res;
    }

    @CrossOrigin
    @GetMapping("/geneeqtl")
    public Result queryGeneEqtlResult(@RequestParam(value = "gene",required = false) String gene,
                                      @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                      @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                      @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                      @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = geneEqtlService.queryGeneEqtl(pageSize,pageIndex-1,gene,sort_field,sort_direction);
        return res;
    }

    @CrossOrigin
    @GetMapping("/genemeqtl")
    public Result queryGeneMeqtlResult(@RequestParam(value = "gene",required = false) String gene,
                                      @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                      @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                      @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                      @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = geneEqtlService.queryGeneMeqtl(pageSize,pageIndex-1,gene,sort_field,sort_direction);
        return res;
    }

    @CrossOrigin
    @GetMapping("/genepqtl")
    public Result queryGenePqtlResult(@RequestParam(value = "gene",required = false) String gene,
                                       @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                       @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                       @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                       @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = geneEqtlService.queryGenePqtl(pageSize,pageIndex-1,gene,sort_field,sort_direction);
        return res;
    }

    @CrossOrigin
    @GetMapping("/genecoloc")
    public Result queryGeneColocResult(@RequestParam(value = "gene",required = false) String gene,
                                      @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                      @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                      @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                      @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = geneEqtlService.queryGeneColoc(pageSize,pageIndex-1,gene,sort_field,sort_direction);
        return res;
    }

    @CrossOrigin
    @GetMapping("/genesmr")
    public Result queryGeneSmrResult(@RequestParam(value = "gene",required = false) String gene,
                                       @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                       @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                       @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                       @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = geneEqtlService.queryGeneSmr(pageSize,pageIndex-1,gene,sort_field,sort_direction);
        return res;
    }

    @CrossOrigin
    @GetMapping("/genecrispr")
    public Result queryGeneCrisprResult(@RequestParam(value = "gene",required = false) String gene,
                                     @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                     @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                     @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                     @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = geneCrisprService.queryGeneCrispr(pageSize,pageIndex-1,gene,sort_field,sort_direction);
        return res;
    }


    @CrossOrigin
    @GetMapping("/genernaseq")
    public Result queryGeneRNASeqResult(@RequestParam(value = "gene",required = false) String gene,
                                        @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                        @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                        @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                        @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = rnaSeqService.queryRNASeq(pageSize,pageIndex-1,gene,sort_field,sort_direction);
        return res;
    }


    @CrossOrigin
    @GetMapping("/genedmg")
    public Result queryGeneDMGSeqResult(@RequestParam(value = "gene",required = false) String gene,
                                        @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                        @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                        @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                        @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = dmgService.queryGeneDMG(pageSize,pageIndex-1,gene,sort_field,sort_direction);
        return res;
    }

}
