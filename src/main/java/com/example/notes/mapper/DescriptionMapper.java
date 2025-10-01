
package com.example.notes.mapper;

import com.example.notes.dto.DescriptionDTO;
import com.example.notes.entity.Description;

public final class DescriptionMapper {

  public static Description toEntity(final DescriptionDTO dto) {
    if (dto == null) {
      return null;
    }
    Description d = new Description();
    d.setId(dto.getId());
    d.setText(dto.getText());
    return d;
  }

  public static DescriptionDTO toDTO(final Description entity) {
    if (entity == null) {
      return null;
    }
    DescriptionDTO dto = new DescriptionDTO();
    dto.setId(entity.getId());
    dto.setText(entity.getText());
    dto.setCreatedAt(entity.getCreatedAt());
    dto.setUpdatedAt(entity.getUpdatedAt());
    return dto;
  }
}
