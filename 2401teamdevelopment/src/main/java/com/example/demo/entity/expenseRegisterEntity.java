package com.example.demo.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;
/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name = "expense_tb",schema="public")
@IdClass(value=expenseRegisterKey.class)
public class expenseRegisterEntity implements Serializable {
  /**
   * 経費ID
   */
  @Column(name = "expense_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long expense_id;
  /**
   * ユーザーID
   */  
  @JoinColumn(name = "user_id")
  private Long user_id;
  /**
   * 申請日
   */
  @Column(name = "application_date")
  private String application_date;
  /**
   * 経費項目
   */
  @Column(name = "category")
  private String category;
  /**
   * 金額
   */
  @Column(name = "amount")
  private String amount;
  /**
   * 備考
   */
  @Column(name = "remarks")
  private String remarks;
  

}
