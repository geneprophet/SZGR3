package cn.ac.cncb.ngdc.szgr.controller;

import cn.ac.cncb.ngdc.szgr.entity.SNPValidate;
import cn.ac.cncb.ngdc.szgr.result.Result;
import cn.ac.cncb.ngdc.szgr.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SNPCuraController {
    @Autowired
    SNPCuraService snpcuraService;

    @Autowired
    SNPAnoService snpanoService;

    @Autowired
    SNPGeneService snpgeneService;

    @Autowired
    SNPMpraService snpmpraService;

    @Autowired
    SNPValidateService snpvalidateService;


    @CrossOrigin
    @GetMapping("/variantcuration")
    public Result querySNPCuraResult(@RequestParam(value = "vid",required = false) String vid,
                                     @RequestParam(value = "vtype",required = false) String vtype,
                                     @RequestParam(value = "pop",required = false) String pop,
                                    @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                    @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = snpcuraService.querySNPCura(pageSize,pageIndex-1,vid,vtype,pop,sort_field,sort_direction);
        return res;
    }
    @CrossOrigin
    @GetMapping("/variantcurationlike")
    public Result querySNPCuraLike(@RequestParam(value = "vid",required = false) String vid,
                                     @RequestParam(value = "vtype",required = false) String vtype,
                                     @RequestParam(value = "pop",required = false) String pop,
                                     @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                     @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                     @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                     @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = snpcuraService.querySNPCuraLike(pageSize,pageIndex-1,vid,vtype,pop,sort_field,sort_direction);
        return res;
    }
    @CrossOrigin
    @GetMapping("/loccuration")
    public Result queryLocCuraResult(@RequestParam(value = "vchr",required = false) String vchr,
                                     @RequestParam(value = "vs",required = false) Integer vs,
                                     @RequestParam(value = "ve",required = false) Integer ve,
                                     @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                     @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                     @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                     @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = snpcuraService.queryLocCura(pageSize,pageIndex-1,vchr,vs,ve,sort_field,sort_direction);
        return res;
    }


    @CrossOrigin
    @GetMapping("/variantano")
    public Result querySNPanoResult(@RequestParam(value = "vid",required = false) String vid,
                                 @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                 @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                 @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                 @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = snpanoService.querySNPAno(pageSize,pageIndex-1,vid,sort_field,sort_direction);
        return res;
    }
    @CrossOrigin
    @GetMapping("/variantanolike")
    public Result querySNPanolikeResult(@RequestParam(value = "vid",required = false) String vid,
                                    @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                    @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = snpanoService.querySNPAnoLike(pageSize,pageIndex-1,vid,sort_field,sort_direction);
        return res;
    }
    @CrossOrigin
    @GetMapping("/locano")
    public Result queryLocAnoResult(@RequestParam(value = "vchr",required = false) String vchr,
                                     @RequestParam(value = "vs",required = false) Integer vs,
                                     @RequestParam(value = "ve",required = false) Integer ve,
                                     @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                     @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                     @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                     @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = snpanoService.queryLocAno(pageSize,pageIndex-1,vchr,vs,ve,sort_field,sort_direction);
        return res;
    }



    @CrossOrigin
    @GetMapping("/variantgene")
    public Result queryLocgeneResult(@RequestParam(value = "vid",required = false) String vid,
                                    @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                    @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                    @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                    @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = snpgeneService.querySNPGene(pageSize,pageIndex-1,vid,sort_field,sort_direction);
        return res;
    }

    @CrossOrigin
    @GetMapping("/variantgenelike")
    public Result queryLocgenelikeResult(@RequestParam(value = "vid",required = false) String vid,
                                     @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                     @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                     @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                     @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = snpgeneService.querySNPGenelike(pageSize,pageIndex-1,vid,sort_field,sort_direction);
        return res;
    }

    @CrossOrigin
    @GetMapping("/locgene")
    public Result querySNPgeneResult(@RequestParam(value = "vchr",required = false) String vchr,
                                     @RequestParam(value = "vs",required = false) Integer vs,
                                     @RequestParam(value = "ve",required = false) Integer ve,
                                     @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                     @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                     @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                     @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = snpgeneService.queryLocGene(pageSize,pageIndex-1,vchr,vs,ve,sort_field,sort_direction);
        return res;
    }



    @CrossOrigin
    @GetMapping("/variantmpra")
    public Result querySNPmpraResult(@RequestParam(value = "vid",required = false) String vid,
                                     @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                     @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                     @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                     @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = snpmpraService.querySNPMpra(pageSize,pageIndex-1,vid,sort_field,sort_direction);
        return res;
    }
    @CrossOrigin
    @GetMapping("/variantmpralike")
    public Result querySNPmpralikeResult(@RequestParam(value = "vid",required = false) String vid,
                                     @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                     @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                     @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                     @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = snpmpraService.querySNPMpralike(pageSize,pageIndex-1,vid,sort_field,sort_direction);
        return res;
    }

    @CrossOrigin
    @GetMapping("/locmpra")
    public Result queryLocgeneResult(@RequestParam(value = "vchr",required = false) String vchr,
                                     @RequestParam(value = "vs",required = false) Integer vs,
                                     @RequestParam(value = "ve",required = false) Integer ve,
                                     @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                     @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                     @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                     @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = snpmpraService.queryLocMpra(pageSize,pageIndex-1,vchr,vs,ve,sort_field,sort_direction);
        return res;
    }



    @CrossOrigin
    @GetMapping("/variantcrispr")
    public Result querySNPCrisprResult(@RequestParam(value = "vid",required = false) String vid,
                                     @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                     @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                     @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                     @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = snpcuraService.querySNPCrispr(pageSize,pageIndex-1,vid,sort_field,sort_direction);
        return res;
    }

    @CrossOrigin
    @GetMapping("/variantcrisprlike")
    public Result querySNPCrisprlikeResult(@RequestParam(value = "vid",required = false) String vid,
                                       @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                       @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                       @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                       @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = snpcuraService.querySNPCrisprlike(pageSize,pageIndex-1,vid,sort_field,sort_direction);
        return res;
    }


    @CrossOrigin
    @GetMapping("/loccrispr")
    public Result queryLocCrisprResult(@RequestParam(value = "vchr",required = false) String vchr,
                                     @RequestParam(value = "vs",required = false) Integer vs,
                                     @RequestParam(value = "ve",required = false) Integer ve,
                                     @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                     @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                     @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                     @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = snpcuraService.queryLocCrispr(pageSize,pageIndex-1,vchr,vs,ve,sort_field,sort_direction);
        return res;
    }

    @CrossOrigin
    @GetMapping("/variantvalidate")
    public Result querySNPValidaterResult(@RequestParam(value = "vid",required = false) String vid,
                                       @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                       @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                       @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                       @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = snpvalidateService.querySNPValidate(pageSize,pageIndex-1,vid,sort_field,sort_direction);
        return res;
    }

    @CrossOrigin
    @GetMapping("/locvalidate")
    public Result queryLocValidaterResult(@RequestParam(value = "vchr",required = false) String vchr,
                                          @RequestParam(value = "vs",required = false) Integer vs,
                                          @RequestParam(value = "ve",required = false) Integer ve,
                                          @RequestParam(value = "sort_field",required = false,defaultValue = "id") String sort_field,
                                          @RequestParam(value = "sort_direction",required = false,defaultValue = "ascend") String sort_direction,
                                          @RequestParam(value = "pageSize",required = false,defaultValue = "10") Integer pageSize,
                                          @RequestParam(value = "pageIndex",required = false,defaultValue = "1") Integer pageIndex
    ){
        Result res = snpvalidateService.queryLocValidate(pageSize,pageIndex-1,vchr,vs,ve,sort_field,sort_direction);
        return res;
    }



}
