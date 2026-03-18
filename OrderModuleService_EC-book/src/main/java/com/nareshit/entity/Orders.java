package com.nareshit.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
	@Table(name = "orders") // it is optional
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public class Orders {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		@Column(name = "bookId")
		private Long bookId;
		
		@Column(name = "custmerId")
		private Long custmerId;
		
		@Column(name = "status")
		private Boolean status;
		
		@CreationTimestamp
		@Column(name = "createdDate" ,updatable = false)
		public LocalDateTime createdDate;
		
		
		@UpdateTimestamp
		@Column(name = "updatedDate")
		public LocalDateTime updatedDate;


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public Long getBookId() {
			return bookId;
		}


		public void setBookId(Long bookId) {
			this.bookId = bookId;
		}


		public Long getCustmerId() {
			return custmerId;
		}


		public void setCustmerId(Long custmerId) {
			this.custmerId = custmerId;
		}


		public Boolean getStatus() {
			return status;
		}


		public void setStatus(Boolean status) {
			this.status = status;
		}


		public LocalDateTime getCreatedDate() {
			return createdDate;
		}


		public void setCreatedDate(LocalDateTime createdDate) {
			this.createdDate = createdDate;
		}


		public LocalDateTime getUpdatedDate() {
			return updatedDate;
		}


		public void setUpdatedDate(LocalDateTime updatedDate) {
			this.updatedDate = updatedDate;
		}


		@Override
		public String toString() {
			return "Orders [id=" + id + ", bookId=" + bookId + ", custmerId=" + custmerId + ", status=" + status
					+ ", createdDate=" + createdDate + ", updatedDate=" + updatedDate + "]";
		}


		public Orders(Long id, Long bookId, Long custmerId, Boolean status, LocalDateTime createdDate,
				LocalDateTime updatedDate) {
			super();
			this.id = id;
			this.bookId = bookId;
			this.custmerId = custmerId;
			this.status = status;
			this.createdDate = createdDate;
			this.updatedDate = updatedDate;
		}


		public Orders() {
			super();
			// TODO Auto-generated constructor stub
		}
		

		
	


}
