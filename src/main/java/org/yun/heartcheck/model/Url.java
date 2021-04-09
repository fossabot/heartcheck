package org.yun.heartcheck.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.yun.heartcheck.util.JpaConverterObjectJson;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@DynamicUpdate
@Data
@ApiModel("url model")
public class Url {

    @Id
    @GenericGenerator(name = "url-uuid", strategy = "uuid")
    @GeneratedValue(generator = "url-uuid")
    @ApiModelProperty(name = "id", value = "主键")
    private String id;

    @ApiModelProperty(name = "url", value = "用来访问的地址")
    private String url;

    @ApiModelProperty(name = "header", value = "请求头信息")
    @Transient
    @Convert(converter = JpaConverterObjectJson.class)
    private Map header;

    @ApiModelProperty(name = "body", value = "请求体信息")
    @Transient
    @Convert(converter = JpaConverterObjectJson.class)
    private Map body;

    @ApiModelProperty(name = "is_delete", value = "删除标识", allowableValues = "alive,death", example = "alive")
    private String is_delete;

    @OneToMany(mappedBy = "url_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ApiModelProperty(name = "taskList", value = "任务列表")
    private List<Task> taskList;
}
