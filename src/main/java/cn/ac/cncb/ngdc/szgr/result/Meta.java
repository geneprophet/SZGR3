package cn.ac.cncb.ngdc.szgr.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meta {

    private Long total;
    private Integer pageSize;
    private Integer pageIndex;

}
