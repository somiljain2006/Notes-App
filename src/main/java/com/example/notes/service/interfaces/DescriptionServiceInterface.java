
package com.example.notes.service.interfaces;

import com.example.notes.entity.Description;
import java.util.List;

public interface DescriptionServiceInterface {
  List<Description> getDescription();
  Description addDescription(Description d);
  Description updateDescription(Description updated, Long id);
  void deleteDescription(Long id);
  Description getDescriptionById(Long id);
}