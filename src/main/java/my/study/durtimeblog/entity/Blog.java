package my.study.durtimeblog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="Blog对象", description="")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "博客标题")
    private String title;

    @ApiModelProperty(value = "博客摘要")
    private String summary;

    @ApiModelProperty(value = "博客内容")
    private String content;

    @ApiModelProperty(value = "发布时间")
    private Date date;

    @ApiModelProperty(value = "所属专栏")
    private Integer type;

    @ApiModelProperty(value = "浏览量")
    private Integer views;

    @ApiModelProperty(value = "标签")
    private String tags;

    @ApiModelProperty(value = "评论")
    private String comments;

    @ApiModelProperty(value = "首图地址")
    @TableField("pictureUrl")
    private String pictureurl;

    @ApiModelProperty(value = "是否开启推荐")
    @TableField("isRecommend")
    private Integer isrecommend=0;

    @ApiModelProperty(value = "是否开启转载声明")
    @TableField("isReprint")
    private Integer isreprint=0;

    @ApiModelProperty(value = "是否开启赞赏")
    @TableField("isAppreciation")
    private Integer isappreciation=0;

    @ApiModelProperty(value = "是否开启评论")
    @TableField("isComment")
    private Integer iscomment=0;

    @ApiModelProperty(value = "1.原创；2.转载；3.翻译")
    private Integer property=1;

    @ApiModelProperty(value = "状态：0.草稿；1.已发布")
    private Integer state;


}
