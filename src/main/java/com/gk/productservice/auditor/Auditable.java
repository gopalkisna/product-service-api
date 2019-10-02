package com.gk.productservice.auditor;

import java.time.LocalDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<U> {
	@CreatedBy
	protected U createdBy;
	@CreatedDate
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected LocalDateTime creationDate;
	@LastModifiedBy
	protected U lastModifiedBy;
	@LastModifiedDate
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	protected LocalDateTime lastModifiedDate;
}
