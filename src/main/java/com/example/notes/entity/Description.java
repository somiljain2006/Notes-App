
package com.example.notes.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

/** Entity representing the content of notes. */
@Entity
@Table(name = "content")
public final class Description {

  /** Primary key for the content. */
  @Id
  @SequenceGenerator(
            name = "user1_sequence",
            sequenceName = "user1_sequence",
            allocationSize = 1
  )
  @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user1_sequence"
  )
  private Long id;

  /** The main text content. */
  @Column(length = 100)
  private String text;

  /** Time when the content was created. */
  @CreationTimestamp
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDateTime createdAt;

  /** Timestamp when the content was last updated. */
  @UpdateTimestamp
  @JsonFormat(pattern = "yyyy-MM-dd")
  private LocalDateTime updatedAt;

  /** Default constructor required by JPA. */
  public Description() {
  }

  /** return the entity ID. */
  public Long getId() {
    return id;
  }

  /**
   * set the entity ID.
   */
  public void setId(final Long id) {
    this.id = id;
  }

  /** return the content text. */
  public String getText() {
    return text;
  }

  /**
   * set the content text.
   * */
  public void setText(final String text) {
    this.text = text;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  @Override
  public String toString() {
    return "id=" + "Description{" + id + ", text='"
            + text + '\'' + ", createdAt="
            + createdAt + ", updatedAt="
            + updatedAt + '}';
  }
}
