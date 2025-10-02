
package com.example.notes.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public class DescriptionDTO {
  private Long id;
  private String text;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDateTime createdAt;

  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDateTime updatedAt;

  public DescriptionDTO() {
  }

  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }
  public void setText(final String text) {
    this.text = text;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
  public void setCreatedAt(final LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(final LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
}

