/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: BaseAuditable
 * Author:   康鸿
 * Date:     2019/8/5 17:25
 * Description: TODO
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kh.pojo.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Description: TODO
 *
 * @author 康鸿
 * @create 2019/8/5
 * @since 1.0.0
 * Description
 */
//可以将该实体类当成基类实体，它不会隐射到数据库表，
// 但继承它的子类实体在隐射时会自动扫描该基类实体的隐射属性，
// 添加到子类实体的对应数据库表中。
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class BaseAuditable {
    @Column(name = "id")
    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    Long id;

    @LastModifiedDate
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "updateTime")
    Date updateTime;

    @CreatedDate
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "createTime")
    Date createTime;

    @Version
    @Column(name = "version")
    private Long version;
}