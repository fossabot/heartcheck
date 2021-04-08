package org.yun.heartcheck.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DynamicUpdate
@Data
@ApiModel("event log")
public class EventLog {

    @Id
    @GenericGenerator(name = "url-uuid", strategy = "uuid")
    @GeneratedValue(generator = "url-uuid")
    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("event_name")
    private String event_name;

    @ApiModelProperty("event_message")
    private String event_message;

    @ApiModelProperty("remark")
    private String remark;

    @ApiModelProperty("time")
    private String time;
}
