package com.example.trainingSpling.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * 科目情報 リクエストデータ
 */

@Data
public class TrainingForm  {
  /**
   * ID
   */
  private Integer id;
  
  /**
   * 種目
   */
  @NotEmpty(message = "種目を入力してください")
  @Size(max = 50, message = "種目は50文字以内で入力してください")
  private String training;
  
  /**
   * 回数
   */
  @NotNull(message = "回数を入力してください")
 
  private Integer rep;

}
