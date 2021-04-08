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
@ApiModel("url model")
public class Url {

    @Id
    @GenericGenerator(name = "url-uuid", strategy = "uuid")
    @GeneratedValue(generator = "url-uuid")
    @ApiModelProperty("id")
    private String id;

    @ApiModelProperty("url")
    private String url;

    @ApiModelProperty("header")
    @Transient
    @Convert(converter = JpaConverterObjectJson.class)
    private Map header;

    @ApiModelProperty("body")
    @Transient
    @Convert(converter = JpaConverterObjectJson.class)
    private Map body;
}
