package com.example.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Item;
import com.example.service.ItemService;

@RestController
@RequestMapping(path = "/")
@ResponseBody
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("items")
	public List<Item> items() {
		return itemService.findAll();
	}

	@GetMapping("items/{id}")
	public String retrieveItem(@PathVariable long id) {
		return itemService.getItem(id);
	}

	@GetMapping("hello")
	public String hello() {
		return "Hello Zzapp";
	}

	@GetMapping("current_time")
	public String current_time() {
		return new Date().toString();
	}

	@Autowired
	public ItemController(ItemService itemService) {
		this.itemService = itemService;
	}


	@RequestMapping(value = "data", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity onResRequest(@RequestParam(value = "id") String id){
		Long Id = Long.parseLong(id);
		return ResponseEntity.ok(itemService.getItem(Id));
	}
}


//package com.example.controller;
//
//import java.util.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.example.entity.Item;
//import com.example.service.ItemService;
//
//@RestController
//@ResponseBody
//public class ItemController {
//
//	@Autowired
//	private ItemService itemService;
//
//	@Autowired
//	public ItemController(ItemService itemService) {
//		this.itemService = itemService;
//	}
//
//
//	@GetMapping("/items")
//	public List<Item> items() {
//		return itemService.findAll();
//	}
//
//	@RequestMapping(value = "data", produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity onResRequest(@RequestParam(value = "id") String id){
//		Long Id = Long.parseLong(id);
//		return ResponseEntity.ok(itemService.getItem(Id));
//	}
//
//	@GetMapping("/items/{id}")
//	public String retrieveItem(@PathVariable long id) {
//		return itemService.getItem(id);
//	}
//
//	@GetMapping("/hello")
//	public String hello() {
//		return "Hello Zzapp";
//	}
//
//	@GetMapping("/current_time")
//	public String current_time() {
//		return new Date().toString();
//	}
//
//}
