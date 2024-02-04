package com.example.demo.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.expenseRegisterRequest;
import com.example.demo.entity.expenseRegisterEntity;
import com.example.demo.service.expenseRegisterService;
/**
 * ユーザー情報 Controller
 */
@Controller
public class expenseRegisterController {
  /**
   * ユーザー情報 Service
   */
  @Autowired
  private expenseRegisterService expenseRegisterService;
  /**
   * （マイページ画面）ユーザー情報一覧画面を表示?
   * @param model Model
   * @return （マイページ画面)ユーザー情報一覧画面?
   */
  @GetMapping(value = "/user/myPage")
  public String myPage(Model model) {
    List<expenseRegisterEntity> myPage = expenseRegisterService.searchAll();
    model.addAttribute("myPage",myPage );
    return "user/myPage";
  }
  /**
   * 経費申請画面を表示
   * @param model Model
   * @return (マイページ)ユーザー情報一覧画面
   */
  @RequestMapping(value="/user/expenseRegister")
  public String expenseRegisterRegister(Model model) {
    model.addAttribute("expenseRegisterRequest", new expenseRegisterRequest());
    return "user/expenseRegister";
  }
  /**
   * (経費申請登録)ユーザー新規登録
   * @param userRequest リクエストデータ
   * @param model Model
   * @return ユーザー情報一覧画面
   */
  @RequestMapping(value="/user/create",method = RequestMethod.POST)
  public String userCreate(@Validated @ModelAttribute expenseRegisterRequest expenseRegisterAttributeRequest, BindingResult result, Model model) {
    if (result.hasErrors()) {
      // 入力チェックエラーの場合
      List<String> errorList = new ArrayList<String>();
      for (ObjectError error : result.getAllErrors()) {
        errorList.add(error.getDefaultMessage());
      }
      model.addAttribute("validationError", errorList);
      return "user/expenseRegister";
    }
    // 経費申請情報の登録
    expenseRegisterService.create(expenseRegisterAttributeRequest);
    return "redirect:/user/myPage";
  }
  
}