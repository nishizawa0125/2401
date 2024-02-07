package com.example.demo.entity;
import java.io.Serializable;

import lombok.Data;
/**
 * 主キー用 Entity
 */
@Data
public class expenseRegisterKey implements Serializable {
  /**
   * 経費ID
   */
  private int expense_id;
}