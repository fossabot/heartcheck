package org.yun.heartcheck.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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

    @ApiModelProperty(name = "task_name", value = "任务名称")
    private String task_name;

    @ApiModelProperty(name = "cron", value = "cron表达式", example = "0/30 * * * * ?")
    private String cron;

    @ApiModelProperty(name = "status", value = "状态标识", allowableValues = "run,stop", example = "run")
    private String status;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
    @JoinColumn(name = "url_id")
    private Url url;
}
