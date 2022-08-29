package my.study.durtimeblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * <p>
 * 
 * </p>
 *
 * @author durtime
 * @since 2022-04-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@ApiModel(value="Type对象", description="")
public class Type implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "专栏名称")
    private String name;

    @ApiModelProperty(value = "专栏简介")
    private String introduction;

    @ApiModelProperty(value = "博客数量")
    private Integer number;

    @ApiModelProperty(value = "更新时间")
    private Date date;


}
