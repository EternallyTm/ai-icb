package com.icb.dal.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 模型表
 */
@Data
@TableName(value = "icb_model")
public class Model {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 模型名称-中文
     */
    @TableField(value = "name_cn")
    private String nameCn;

    /**
     * 模型名称
     */
    @TableField(value = "name_en")
    private String nameEn;

    /**
     * 部署方式：1-在线大模型 2-私有大模型
     */
    @TableField(value = "deploy_method")
    private Byte deployMethod;

    /**
     * 模型类型：1-大语言模型 2-embedding模型
     */
    @TableField(value = "`type`")
    private Byte type;

    /**
     * 模型地址：私有大模型类型下，下载模型的地址
     */
    @TableField(value = "model_url")
    private String modelUrl;

    /**
     * 模型的app_key，在线大模型时必传
     */
    @TableField(value = "app_key")
    private String appKey;

    /**
     * 创建时间
     */
    @TableField(value = "created_at")
    private Date createdAt;

    /**
     * 创建人
     */
    @TableField(value = "created_by")
    private Long createdBy;

    /**
     * 更新时间
     */
    @TableField(value = "updated_at")
    private Date updatedAt;

    @TableField(value = "updated_by")
    private Long updatedBy;
}