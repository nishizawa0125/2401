package com.example.demo.service;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.expenseRegisterRequest;
import com.example.demo.entity.expenseRegisterEntity;
import com.example.demo.repository.expenseRegisterRepository;
/**
 * ユーザー情報 Service
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class expenseRegisterService {
  /**
   * ユーザー情報 Repository
   */
  @Autowired
  private static expenseRegisterRepository expenseRegisterRepository;
  /**
   * ユーザー情報 全検索
   * @return 検索結果
   */
  public List<expenseRegisterEntity> searchAll() {
    return expenseRegisterRepository.findAll();
  }
  

  /**
   * ユーザー情報 新規登録
   * @param user ユーザー情報
   */
  public void create(expenseRegisterRequest expenseRegisterRequest) {
    Date now = new Date();
    expenseRegisterEntity user = new expenseRegisterEntity();
    user.setExpense_id(expenseRegisterRequest.getExpense_id());
    user.setUser_id(expenseRegisterRequest.getUser_id());
    user.setApplication_date(expenseRegisterRequest.getApplication_date());
    user.setCategory(expenseRegisterRequest.getCategory());
    user.setAmount(expenseRegisterRequest.getAmount());
    user.setRemarks(expenseRegisterRequest.getRemarks());
    
    expenseRegisterRepository.save(user);
  }

}