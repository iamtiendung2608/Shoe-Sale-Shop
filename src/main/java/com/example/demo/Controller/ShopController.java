package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.database.ItemRepo;
import com.example.demo.database.Items;
import com.example.demo.database.ItemsDetails;
@Controller
public class ShopController {
	@Autowired
	ItemRepo repo;
	
	List<Items>Product=Items.getImage();
	List<ItemsDetails>DetailsItems=ItemsDetails.getItems();
	@RequestMapping("/shop")
	public String shoping(Model model) {
		model.addAttribute("Items", Product);
		for(Items i:Product) {
			repo.save(i);
		}
		return "shopping-page";
	}
	@GetMapping("/details/{id}")
	public String details(@PathVariable("id")int id, Model model) {
		ItemsDetails Items1 =DetailsItems.get(id);
		Items1.setItem(Product.get(id));
		Items1.setName();
		model.addAttribute("Items", Items1);
		return "Show-Items";
	}
}





