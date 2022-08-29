package my.study.durtimeblog.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import my.study.durtimeblog.entity.Blog;
import my.study.durtimeblog.entity.Comment;
import my.study.durtimeblog.entity.Tag;

import java.util.Date;
import java.util.List;

/**
 * blog
 *
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BlogViewmodel {
    private Blog blog;
    /** 标签 */
    private List<Tag> tags;

    private String htmlcontent;


}