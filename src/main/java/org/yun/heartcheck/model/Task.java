package org.yun.heartcheck.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.yun.heartcheck.util.JpaConverterObjectJson;

import javax.persistence.*;
import java.util.Map;

@Entity
@DynamicUpdate
@Data
@ApiModel("task model")
public class Task {
    @Id
    @GenericGenerator(name = "task-uuid", strategy = "uuid")
    @GeneratedValue(generator = "task-uuid")
    @ApiModelProperty(name = "id", value = "主键")
    private String id;

    @ApiModelProperty(name = "url_id", value = "确定是哪一条url的")
    private String url_id;

    @ApiModelProperty(name = "body", value = "请求体信息")
    @Transient
    @Convert(converter = JpaConverterObjectJson.class)
    private Map body;

    @ApiModelProperty(name = "status", value = "状态标识", allowableValues = "run,stop", example = "run")
    private String status;

    @ApiModelProperty(name = "cron", value = "cron表达式", example = "0/30 * * * * ?")
    private String cron;
}
