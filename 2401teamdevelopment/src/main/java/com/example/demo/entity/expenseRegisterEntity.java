package com.example.demo.entity;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name = "expense_tb")
public class expenseRegisterEntity implements Serializable {
  /**
   * ユーザーID
   */
  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
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
  private Date updateDate;
}
