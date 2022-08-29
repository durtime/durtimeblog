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
@ApiModel(value="Comment对象", description="")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "发表评论的用户名称")
    private String name;

    @ApiModelProperty(value = "邮箱地址")
    private String email;

    @ApiModelProperty(value = "博客ID编号")
    private Integer blog;

    @ApiModelProperty(value = "发布时间")
    private Date time;

    @ApiModelProperty(value = "是否是管理员")
    @TableField("isAdmin")
    private Integer isadmin;

    @ApiModelProperty(value = "评论内容")
    private String content;

    @ApiModelProperty(value = "父评论的id")
    private Integer parent;


}
