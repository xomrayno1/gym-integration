package com.app.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.app.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -4791606917079116564L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	protected Long id;

	@CreatedDate
	@Column(name = "created_at", nullable = false, updatable = false)
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDateTime createdAt;

	@LastModifiedDate
	@Column(name = "updated_at")
	@JsonFormat(shape = Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDateTime updatedAt;

	@Column(name = "status", nullable = false)
	@Convert(converter = Status.Converter.class)
	private Status status = Status.ACTIVE;

}
