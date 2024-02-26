package com.example.trainingSpling.controller;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.trainingSpling.entity.TrainingEntity;
import com.example.trainingSpling.form.TrainingForm;
import com.example.trainingSpling.service.TrainingService;



/**
 * 種目情報 Controller
 */
@Controller
public class TrainingController {

	/**
	 * 種目情報 Service
	 */
@Autowired
TrainingService trainingService;

	/**
	 * 種目情報一覧画面を表示
	 * @param  model Model
	 * @return  種目情報一覧画面のHTML
	 */
	@GetMapping("/training/list")
	public String trainingList(Model model) {
		List<TrainingEntity> traininglist = trainingService.searchAll();
		model.addAttribute("traininglist", traininglist);
		return "training/list";
	}
	
	/**
	 * 種目新規登録画面を表示
	 * @param  model Model
	 * @return  種目情報一覧画面
	 */
	@GetMapping("/training/add")
	public String trainingRegister(Model model) {
		model.addAttribute("trainingRequest", new TrainingForm());
		return "training/add";
	}
	/**
	 * 種目新規登録
	 * @param  userRequest リクエストデータ
	 * @param  model Model
	 * @return  種目情報一覧画面
	 */
	@RequestMapping("/training/create")
	public String trainingCreate(@Validated  @ModelAttribute  TrainingForm trainingRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			// 入力チェックエラーの場合
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("trainingRequest", new TrainingForm());
			model.addAttribute("validationError", errorList);
			return "training/add";
		}
		// 種目情報の登録
		trainingService.create(trainingRequest);
		return "redirect:/training/list";
	}	

	/**
	 * 種目情報詳細画面を表示
	 * @param  id 表示する科目ID
	 * @param  model Model
	 * @return  種目情報詳細画面
	 */
	@GetMapping("/training/{id}")
	public String userDetail(@PathVariable  Integer id, Model model) {
		TrainingEntity training = trainingService.findById(id);
		model.addAttribute("training", training);
		return "training/detail";
	}
	/**
	 * 種目編集画面を表示
	 * @param  id 表示する科目ID
	 * @param  model Model
	 * @return  種目編集画面
	 */
	@GetMapping("/training/{id}/edit")
	public String userEdit(@PathVariable  Integer id, Model model) {
		TrainingEntity training = trainingService.findById(id);
		TrainingForm trainingUpdateRequest = new TrainingForm();
		trainingUpdateRequest.setId(training.getId());
		trainingUpdateRequest.setTraining(training.getTraining());
		model.addAttribute("trainingUpdateRequest", trainingUpdateRequest);
		return "training/edit";
	}
	/**
	 * 種目更新
	 * @param  userRequest リクエストデータ
	 * @param  model Model
	 * @return  種目情報詳細画面
	 */
	@PostMapping("/training/update")
	public String trainingUpdate(@Validated  @ModelAttribute  TrainingForm trainingUpdateRequest, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<String> errorList = new ArrayList<String>();
			for (ObjectError error : result.getAllErrors()) {
				errorList.add(error.getDefaultMessage());
			}
			model.addAttribute("validationError", errorList);
			return "training/edit";
		}
		// 種目情報の更新
		trainingService.update(trainingUpdateRequest);
		return String.format("redirect:/training/%d", trainingUpdateRequest.getId());
	}
	
	/**
	 * 種目情報削除
	 * @param  id 表示するID
	 * @param  model Model
	 * @return  種目情報詳細画面
	 */
	@GetMapping("/training/{id}/delete")
	public String trainingDelete(@PathVariable Integer id, Model model) {
		// 種目情報の削除
		trainingService.delete(id);
		return "redirect:/training/list";
	}


	
}
