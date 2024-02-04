package com.example.demo.dto;
import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
/**
 * ユーザー情報 リクエストデータ
 */
@Data
public class expenseRegisterRequest implements Serializable {
  /**
   * 経費ID
   */
  @NotEmpty(message = "経費IDを入力してください")
  @Size
  private Long expense_id;
  /**
   * ユーザーID
   */
  @NotEmpty(message = "ユーザーIDを入力してください")
  @Size
  private Long user_id;
  /**
   * 申請日
   */
  @NotEmpty(message = "申請日を入力してください")
  @DateTimeFormat(pattern = "yyyy/MM/dd")
  private String application_date;
  /**
   * 経費項目
   */
  @NotEmpty(message = "経費項目を入力してください")
  @Size
  private String category;
  /**
   * 金額
   */
  @NotEmpty(message = "金額を入力してください")
  @Size
  private String amount;
  /**
   * 備考
   */
  @Size(message = "100桁以内で入力してください")
  private String remarks;
}
 